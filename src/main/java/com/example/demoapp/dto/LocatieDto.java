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

import com.example.demoapp.model.Sport;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by TheoNicolae on 05/08/2018.
 */
public class LocatieDto implements Serializable {

  @NotNull
  private String nume;
  @NotNull
  private String tara;
  @NotNull
  private String regiune;
  @NotNull
  private Set<Sport> sport = new HashSet<>();


  public String getNume() {
    return nume;
  }

  public void setNume(String nume) {
    this.nume = nume;
  }

  public String getTara() {
    return tara;
  }

  public void setTara(String tara) {
    this.tara = tara;
  }

  public String getRegiune() {
    return regiune;
  }

  public void setRegiune(String regiune) {
    this.regiune = regiune;
  }

  public Set<Sport> getSport() {
    return sport;
  }

  public void setSport(HashSet<Sport> sport) {
    this.sport = sport;
  }
}
