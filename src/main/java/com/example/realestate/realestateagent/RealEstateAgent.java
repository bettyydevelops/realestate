package com.example.realestate.realestateagent;

import com.example.realestate.customer.Customer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(schema="realestatedb", name="REAL_ESTATE_AGENT")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
public class RealEstateAgent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "AGENT_ID")
  private Long id;

  @Column(name = "AGENT_NAME")
  private String agentName;

  @Column(name = "AUTHORIZED_PERSON")
  private String authorizedPerson;

  @Column(name = "ADDRESS")
  private String address;

  @Column(name = "PHONE")
  private String phone;

  @Column
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(schema = "realestatedb",
      name = "AGENT_CUSTOMER",
      joinColumns = @JoinColumn(name = "AGENT_ID"),
      inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID"))
  Set<Customer> customers;

}
