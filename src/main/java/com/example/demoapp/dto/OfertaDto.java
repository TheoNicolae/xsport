


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
