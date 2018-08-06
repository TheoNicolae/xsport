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

import com.example.demoapp.model.AdminUser;
import com.example.demoapp.repo.AdminUserRepo;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by TheoNicolae on 06/08/2018.
 */
public class AdminService {

  @Autowired
  private AdminUserRepo userRepo;


  public JSONObject createUser(String username, String password) {
    AdminUser u = new AdminUser();
    u.setUsername(username);
    u.setPassword(password);
    userRepo.save(u);

    JSONObject response = new JSONObject();
    response.put("Admin User salvat!", userRepo.findAll());
    return response;
  }

  public JSONObject getAllAdmins() {
    JSONObject response = new JSONObject();
    response.put("Lista de admini :", userRepo.findAll());
    return response;
  }
}
