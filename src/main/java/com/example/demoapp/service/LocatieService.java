/*
 * Copyright (c) 2018, UXP Systems, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of UXP Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to UXP Systems Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from UXP Systems Incorporated.
 * UXDR, ULM, Powering The Digital User Lifecycle and User Lifecycle Management
 * are all trademarks of UXP Systems Inc.
 */


package com.example.demoapp.service;

import com.example.demoapp.dto.LocatieDto;
import com.example.demoapp.model.Locatie;
import com.example.demoapp.model.Regiune;
import com.example.demoapp.model.Tara;
import com.example.demoapp.repo.LocatieRepo;
import com.example.demoapp.repo.SportRepo;
import com.example.demoapp.repo.TaraRepo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by TheoNicolae on 06/08/2018.
 */
public class LocatieService {
  @Autowired
  private LocatieRepo locatieRepo;
  @Autowired
  private SportRepo sportRepo;
  @Autowired
  private TaraRepo taraRepo;

  public JSONObject addLocatie(LocatieDto locatieDto) {

    Tara tara = new Tara();
    tara.setNume(locatieDto.getTara());

    Regiune regiune = new Regiune();
    regiune.setNume(locatieDto.getRegiune());
    regiune.setTara(tara);

    Locatie locatie = new Locatie();
    locatie.setNume(locatieDto.getNume());
    locatie.setRegiune(regiune);
    locatie.setSport(locatieDto.getSport());
    locatie.getSport().forEach(sport -> sport.getLocatii().add(locatie));

    locatieRepo.save(locatie);
    return locationSuccessResponse();

  }

  private JSONObject locationSuccessResponse() {
    JSONObject response = new JSONObject();
    response.put("Locatie salvata cu succes!", locatieRepo.findAll());
    return response;
  }

}
