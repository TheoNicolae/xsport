


package com.example.demoapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by TheoNicolae on 04/08/2018.
 */
@Entity
public class Locatie {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String nume;

  @JsonBackReference
  @ManyToOne(cascade = CascadeType.ALL)
  private Regiune regiune;

  @ManyToMany(mappedBy = "locatii", cascade = CascadeType.ALL)
  private Set<Sport> sport = new HashSet<>();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNume() {
    return nume;
  }

  public void setNume(String nume) {
    this.nume = nume;
  }

  public Regiune getRegiune() {
    return regiune;
  }

  public void setRegiune(Regiune regiune) {
    this.regiune = regiune;
  }

  public Set<Sport> getSport() {
    return sport;
  }

  public void setSport(Set<Sport> sport) {
    this.sport = sport;
  }
}
