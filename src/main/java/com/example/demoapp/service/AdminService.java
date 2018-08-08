

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

  //Clasa asta a fost creata in scopul securizarii api-urilor din path-ul /xsport/admin
  //Ramane de implementat aceasta functionalitate
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
