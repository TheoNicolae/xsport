


package com.example.demoapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by TheoNicolae on 04/08/2018.
 */
@Entity
@Table(name = "tara")
public class Tara implements Serializable {


  @NotNull
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String nume;
  @JsonManagedReference
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Regiune> regiuni = new HashSet<>();

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

  public Set<Regiune> getRegiuni() {
    return regiuni;
  }

  public void setRegiuni(Regiune regiune) {
    this.regiuni.add(regiune);
  }
}
