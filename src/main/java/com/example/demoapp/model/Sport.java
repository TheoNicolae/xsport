


package com.example.demoapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by TheoNicolae on 04/08/2018.
 */
@Entity
public class Sport {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String denumire;

  @ManyToMany(cascade = CascadeType.ALL)
  @JsonBackReference
  @JoinTable(name = "locatie_sport",
      joinColumns = @JoinColumn(name = "sport_id"),
      inverseJoinColumns = @JoinColumn(name = "locatie_id")
  )
  private Set<Locatie> locatii = new HashSet<>();

  private Double cost;

  private String lunaInceput;

  private String lunaFinal;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDenumire() {
    return denumire;
  }

  public void setDenumire(String denumire) {
    this.denumire = denumire;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Set<Locatie> getLocatii() {
    return locatii;
  }

  public void setLocatii(Set<Locatie> locatii) {
    this.locatii = locatii;
  }

  public String getLunaInceput() {
    return lunaInceput;
  }

  public void setLunaInceput(String lunaInceput) {
    this.lunaInceput = lunaInceput;
  }

  public String getLunaFinal() {
    return lunaFinal;
  }

  public void setLunaFinal(String lunaFinal) {
    this.lunaFinal = lunaFinal;
  }

  public String getPerioada() {
    return lunaInceput + '-' + lunaFinal;
  }
}
