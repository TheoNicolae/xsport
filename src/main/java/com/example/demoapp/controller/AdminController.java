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

}
