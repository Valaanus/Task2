package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age ;
    private double salary;

    public Student() {
    }
    

   public Student(int id, String name, int age, double salary) {
      super();
      this.id = id;
      this.name = name;
      this.age = age;
      this.salary = salary;
   }


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public double getSalary() {
      return salary;
   }

   public void setSalary(double salary) {
      this.salary = salary;
   }

    
}
