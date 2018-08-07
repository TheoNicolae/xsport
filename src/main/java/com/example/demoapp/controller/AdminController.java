


package com.example.demoapp.controller;

import com.example.demoapp.dto.LocatieDto;
import com.example.demoapp.service.AdminService;
import com.example.demoapp.service.LocatieService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by TheoNicolae on 04/08/2018.
 */
@Controller
@RequestMapping(path = "/xsport/admin")
public class AdminController {

  @Autowired
  private AdminService adminService;
  @Autowired
  private LocatieService locatieService;


  @GetMapping(path = "/addAdmin")
  @ResponseBody
  public JSONObject addNewUser(@RequestParam String username, @RequestParam String password) {
    return adminService.createUser(username, password);
  }

  @GetMapping(path = "/getAdminList")
  @ResponseBody
  public JSONObject getAdmins() {
    return adminService.getAllAdmins();
  }

  @RequestMapping(path = "/addLocatie", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject addLocatie(@RequestBody LocatieDto locatieDto) {
    return locatieService.addLocatie(locatieDto);
  }

  @GetMapping(path = "/deleteLocatie")
  @ResponseBody
  public JSONObject deleteLocatie(@RequestParam String numeLocatie) {
    return locatieService.stergeLocatie(numeLocatie);
  }

  @GetMapping(path = "/getListaLocatii")
  @ResponseBody
  public JSONObject getListaLocatii() {
    return locatieService.getAllLocatii();
  }

  @RequestMapping(path = "/UpdateLocatie", method = RequestMethod.POST)
  @ResponseBody
  public JSONObject updateLocatie(@RequestParam String numeLocatie, @RequestBody LocatieDto locatieDto) {
    return locatieService.updateLocatie(numeLocatie, locatieDto);
  }


}
