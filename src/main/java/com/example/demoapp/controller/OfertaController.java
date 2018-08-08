

package com.example.demoapp.controller;

import com.example.demoapp.dto.OfertaDto;
import com.example.demoapp.service.LocatieService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by TheoNicolae on 07/08/2018.
 */
@Controller
@RequestMapping(path = "/xsport/")
public class OfertaController {

  @Autowired
  private LocatieService locatieService;

  @RequestMapping(path = "/oferta", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject addLocatie(@RequestBody OfertaDto ofertaDto) {
    return locatieService.getOfertaLocatii(ofertaDto);
  }
}
