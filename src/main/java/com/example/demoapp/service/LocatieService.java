
package com.example.demoapp.service;

import com.example.demoapp.dto.LocatieDto;
import com.example.demoapp.dto.OfertaDto;
import com.example.demoapp.model.Locatie;
import com.example.demoapp.model.Regiune;
import com.example.demoapp.model.Sport;
import com.example.demoapp.model.Tara;
import com.example.demoapp.repo.LocatieRepo;
import com.example.demoapp.repo.RegiuneRepo;
import com.example.demoapp.repo.SportRepo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by TheoNicolae on 06/08/2018.
 */
public class LocatieService {

  @Autowired
  private LocatieRepo locatieRepo;
  @Autowired
  private RegiuneRepo regiuneRepo;
  @Autowired
  private SportRepo sportRepo;

  public JSONObject addLocatie(LocatieDto locatieDto) {

    Tara tara = new Tara();
    tara.setNume(locatieDto.getTara());

    Regiune regiune = buildRegiune(locatieDto, tara);
    Locatie locatie = buildLocatie(regiune, locatieDto);

    locatieRepo.save(locatie);
    return locationResponse("Locatia a fost salvata cu succes!");

  }

  public JSONObject updateLocatie(String nume, LocatieDto locatieDto) {

    Optional<Locatie> loc = getLocatieByName(nume);

    if (!loc.isPresent()) {
      return locationResponse("Locatia nu a fost gasita!");
    }

    Locatie locatie = loc.get();
    locatie.setNume(locatieDto.getNume());
    Regiune regiune = locatie.getRegiune();

    if (!regiune.getNume().equals(locatieDto.getRegiune())) {
      regiune.setNume(locatieDto.getRegiune());
    }

    locatieRepo.save(locatie);
    return locationResponse("Locatia a fost updatata cu succes!");

  }

  public JSONObject stergeLocatie(String nume) {

    Optional<Locatie> locatie = getLocatieByName(nume);
    if (!locatie.isPresent()) {
      return locationResponse("Locatia nu a fost gasita!");
    }
    locatieRepo.deleteById(locatie.get().getId());
    return locationResponse("Locatie stearsa cu succes!");
  }

  public JSONObject getAllLocatii() {
    JSONObject response = new JSONObject();
    response.put("Lista locatii :", locatieRepo.findAll());
    return response;
  }

  public JSONObject getOfertaLocatii(OfertaDto ofertaDto) {
    Iterable<Sport> sporturi = sportRepo.findAll();
    List<Sport> lista = new ArrayList<>();
    for (String sport : ofertaDto.getSporturi()) {
      List<Sport> listaInner = StreamSupport
          .stream(sporturi.spliterator(), false)
          .filter(s -> s.getNume().equalsIgnoreCase(sport))
          .collect(Collectors.toList());
      lista.add(listaInner.get(0));
    }
    if (lista == null) {
      return locationResponse("Sportul selectat nu exista!");
    }

    List<Sport> sporturiFunctieDePerioada = new ArrayList<>();
    sporturiFunctieDePerioada.addAll(getSporturiByPerioada(ofertaDto.getPerioadaMaxima(), lista));
    sporturiFunctieDePerioada.addAll(getSporturiByPerioada(ofertaDto.getPerioadaMinima(), lista));
    List<Sport> listWithoutDuplicates = sporturiFunctieDePerioada.stream().distinct().collect(Collectors.toList());
    if (listWithoutDuplicates.isEmpty()) {
      return ofertaResponse("Nu a fost gasit niciun sport in perioada selectata !", listWithoutDuplicates);
    }
    listWithoutDuplicates.sort(Comparator.comparing(Sport::getCost));
    return ofertaResponse("Oferta :", listWithoutDuplicates);
  }

  private List<Sport> getSporturiByPerioada(String perioada, List<Sport> lista) {

    return lista.stream()
        .filter(sport -> sport.getPerioada()
            .contains(perioada
                .substring(perioada.length() - 3)))
        .collect(Collectors.toList());
  }

  private JSONObject ofertaResponse(String s, List<Sport> list) {
    JSONObject response = new JSONObject();
    response.put(s, list);
    return response;
  }

  private JSONObject locationResponse(String s) {
    JSONObject response = new JSONObject();
    response.put(s, locatieRepo.findAll());
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
