package com.example.realestate.realestate;

import com.example.realestate.customer.Customer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="realestatedb", name="ESTATE")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RealEstate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ESTATE_ID")
  Long id;

  @Column(name = "CITY")
  String city;

  @Column(name = "DISTRICT")
  String district;

  @Column(name = "ESTATE_TYPE")
  String type;

  @Column(name = "MSQUARE")
  Integer meterSquare;

  @Column(name = "ROOM_COUNT")
  Integer roomCount;

  @Column(name = "FLAT_FLOOR")
  Integer flatFloor;

  @Column(name = "BUILDING_FLOOR_COUNT")
  Integer buildingFloorCount;

  @Column(name = "FOR_SALE")
  boolean forSale;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "CUSTOMER_ID")
  @OnDelete(action = OnDeleteAction.CASCADE)
  Customer customer;

  public RealEstate(String city, String district, String type, Integer meterSquare, Integer roomCount,
                    Integer flatFloor, Integer buildingFloorCount, boolean forSale, Customer customer) {
    this.city = city;
    this.district = district;
    this.type = type;
    this.meterSquare = meterSquare;
    this.roomCount = roomCount;
    this.flatFloor = flatFloor;
    this.buildingFloorCount = buildingFloorCount;
    this.forSale = forSale;
    this.customer = customer;
  }
}
