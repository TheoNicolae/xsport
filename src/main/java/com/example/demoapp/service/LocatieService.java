
package com.example.demoapp.service;

import com.example.demoapp.dto.LocatieDto;
import com.example.demoapp.model.Locatie;
import com.example.demoapp.model.Regiune;
import com.example.demoapp.model.Tara;
import com.example.demoapp.repo.LocatieRepo;
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

  public JSONObject addLocatie(LocatieDto locatieDto) {

    Tara tara = new Tara();
    tara.setNume(locatieDto.getTara());

    Regiune regiune = new Regiune();
    regiune.setNume(locatieDto.getRegiune());
    regiune.setTara(tara);
    tara.setRegiuni(regiune);

    Locatie locatie = new Locatie();
    locatie.setNume(locatieDto.getNume());
    locatie.setRegiune(regiune);
    locatie.setSport(locatieDto.getSport());
    locatie.getSport().forEach(sport -> sport.getLocatii().add(locatie));
    regiune.getLocatii().add(locatie);

    locatieRepo.save(locatie);
    return locationSuccessResponse();

  }

  public JSONObject stergeLocatie(String nume) {

    Iterable<Locatie> locatii = locatieRepo.findAll();
    Optional<Locatie> locatie = StreamSupport
        .stream(locatii.spliterator(), false)
        .filter(l -> l.getNume().equalsIgnoreCase(nume))
        .findAny();
    if (!locatie.isPresent()) {
      return locationNotFoundResponse();
    }
    locatieRepo.delete(locatie.get());
    return locationSuccessResponse();
  }

  public JSONObject getAllLocatii(){
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

}
