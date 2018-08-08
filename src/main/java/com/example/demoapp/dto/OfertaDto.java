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


package com.example.demoapp.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by TheoNicolae on 07/08/2018.
 */
public class OfertaDto {

  @NotNull
  private String perioadaMinima;
  @NotNull
  private String perioadaMaxima;
  @NotNull
  private String[] sporturi;
  @NotNull
  public String getPerioadaMinima() {
    return perioadaMinima;
  }

  public void setPerioadaMinima(String perioadaMinima) {
    this.perioadaMinima = perioadaMinima;
  }

  public String getPerioadaMaxima() {
    return perioadaMaxima;
  }

  public void setPerioadaMaxima(String perioadaMaxima) {
    this.perioadaMaxima = perioadaMaxima;
  }

  public String[] getSporturi() {
    return sporturi;
  }

  public void setSporturi(String[] sporturi) {
    this.sporturi = sporturi;
  }
}
