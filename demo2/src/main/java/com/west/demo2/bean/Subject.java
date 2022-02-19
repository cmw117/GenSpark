package com.west.demo2.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subject")
public class Subject {
     @Id
     @Column(name = "id", nullable = false)
     private Long id;

     private String name;
     private String description;
     private float price;


     public Subject () {

     }
     public Subject(String name, String description, float price) {
          super();
          this.name = name;
          this.description = description;
          this.price = price;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public float getPrice() {
          return price;
     }

     public void setPrice(float price) {
          this.price = price;
     }
}
