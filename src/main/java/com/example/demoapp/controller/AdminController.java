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

import com.example.demoapp.model.AdminUser;
import com.example.demoapp.repo.AdminUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by TheoNicolae on 04/08/2018.
 */
@Controller
@RequestMapping(path = "/xsport")
public class AdminController {

  private static final String RASPUNS = "Userul a fost salvat";

  @Autowired
  private AdminUserRepo userRepo;

  @GetMapping(path = "/addAdmin")
  public @ResponseBody
  String addNewUser(@RequestParam String username, @RequestParam String password) {

    AdminUser user = new AdminUser();
    user.setUsername(username);
    user.setPassword(password);
    userRepo.save(user);
    return RASPUNS;
  }

  @GetMapping(path = "/getAdminList")
  public @ResponseBody Iterable<AdminUser> getAdmins() {
    return userRepo.findAll();
  }
}
