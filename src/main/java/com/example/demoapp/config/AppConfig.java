

package com.example.demoapp.config;

import com.example.demoapp.service.AdminService;
import com.example.demoapp.service.LocatieService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by TheoNicolae on 06/08/2018.
 */
@Configuration
public class AppConfig {

  @Bean
  public AdminService adminService(){
    return new AdminService();
  }
  @Bean
  public LocatieService locatieService(){
    return new LocatieService();
  }

}
