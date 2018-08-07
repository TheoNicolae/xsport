
package com.example.demoapp.service;

import com.example.demoapp.dto.LocatieDto;
import com.example.demoapp.model.Locatie;
import com.example.demoapp.model.Regiune;
import com.example.demoapp.model.Tara;
import com.example.demoapp.repo.LocatieRepo;
import com.example.demoapp.repo.RegiuneRepo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Created by TheoNicolae on 06/08/2018.
 */
public class LocatieService {

  @Autowired
  private LocatieRepo locatieRepo;
  @Autowired
  private RegiuneRepo regiuneRepo;

  public JSONObject addLocatie(LocatieDto locatieDto) {

    Tara tara = new Tara();
    tara.setNume(locatieDto.getTara());

    Regiune regiune = buildRegiune(locatieDto, tara);
    Locatie locatie = buildLocatie(regiune, locatieDto);

    locatieRepo.save(locatie);
    return locationSuccessResponse();

  }

  public JSONObject updateLocatie(String nume, LocatieDto locatieDto) {

    Optional<Locatie> loc = getLocatieByName(nume);

    if (!loc.isPresent()) {
      return locationNotFoundResponse();
    }

    Locatie locatie = loc.get();
    locatie.setNume(locatieDto.getNume());
    Regiune regiune = locatie.getRegiune();

    if (!regiune.getNume().equals(locatieDto.getRegiune())) {
      regiune.setNume(locatieDto.getRegiune());
    }

    locatieRepo.save(locatie);
    return locationSuccessResponse();

  }

  public JSONObject stergeLocatie(String nume) {

    Optional<Locatie> locatie = getLocatieByName(nume);
    if (!locatie.isPresent()) {
      return locationNotFoundResponse();
    }
    locatieRepo.delete(locatie.get());
    return locationSuccessResponse();
  }

  public JSONObject getAllLocatii() {
    JSONObject response = new JSONObject();
    response.put("Lista locatii :", locatieRepo.findAll());
    return response;
  }

  private JSONObject locationSuccessResponse() {
    JSONObject response = new JSONObject();
    response.put("Locatie salvata cu succes!", locatieRepo.findAll());
    return response;
  }

  private JSONObject locationNotFoundResponse() {
    JSONObject response = new JSONObject();
    response.put("Locatia nu a fost gasita!", locatieRepo.findAll());
    return response;
  }

  private Optional<Locatie> getLocatieByName(String nume) {
    Iterable<Locatie> locatii = locatieRepo.findAll();
    return StreamSupport
        .stream(locatii.spliterator(), false)
        .filter(l -> l.getNume().equalsIgnoreCase(nume))
        .findAny();
  }

  private Optional<Regiune> getRegiuneByName(String nume) {
    Iterable<Regiune> locatii = regiuneRepo.findAll();
    return StreamSupport
        .stream(locatii.spliterator(), false)
        .filter(l -> l.getNume().equalsIgnoreCase(nume))
        .findAny();
  }

  private Regiune buildRegiune(LocatieDto locatieDto, Tara tara) {

    Optional<Regiune> reg = getRegiuneByName(locatieDto.getRegiune());
    Regiune regiune = new Regiune();

    if (!reg.isPresent()) {
      regiune.setNume(locatieDto.getRegiune());
      regiune.setTara(tara);
    } else {
      regiune = reg.get();
    }

    tara.setRegiuni(regiune);

    return regiune;
  }

  private Locatie buildLocatie(Regiune regiune, LocatieDto locatieDto) {

    Locatie locatie = new Locatie();
    locatie.setNume(locatieDto.getNume());
    locatie.setRegiune(regiune);
    locatie.setSport(locatieDto.getSport());
    locatie.getSport().forEach(sport -> sport.getLocatii().add(locatie));
    regiune.getLocatii().add(locatie);

    return locatie;
  }
}
