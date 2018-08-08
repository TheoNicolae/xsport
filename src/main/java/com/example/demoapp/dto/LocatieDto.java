


package com.example.demoapp.dto;

import com.example.demoapp.model.Sport;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
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
