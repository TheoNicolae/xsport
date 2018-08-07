


package com.example.demoapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TheoNicolae on 04/08/2018.
 */
@Entity
public class Regiune {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String nume;

  @JsonManagedReference
  @OneToMany(cascade = CascadeType.ALL)
  private List<Locatie> locatii = new ArrayList<>();

  @JsonBackReference
  @ManyToOne(cascade = CascadeType.ALL)
  private Tara tara;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNume() {
    return nume;
  }

  public void setNume(String nume) {
    this.nume = nume;
  }

  public Tara getTara() {
    return tara;
  }

  public void setTara(Tara tara) {
    this.tara = tara;
  }

  public List<Locatie> getLocatii() {
    return locatii;
  }

  public void setLocatii(List<Locatie> locatii) {
    this.locatii = locatii;
  }
}
