package com.example.realestate.customer;

import com.example.realestate.realestate.RealEstate;
import com.example.realestate.realestateagent.RealEstateAgent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(schema="realestatedb", name="customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  Long id;

  @Column(name = "FIRSTNAME")
  String firstName;

  @Column(name = "LASTNAME")
  String lastName;

  @Column(name = "ADDRESS")
  String address;

  @Column(name = "EMAIL")
  String email;


  @JsonIgnore
  @ManyToMany(mappedBy = "customers", fetch = FetchType.LAZY)
  Set<RealEstateAgent> realEstateAgents;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<RealEstate> realEstates;
}
