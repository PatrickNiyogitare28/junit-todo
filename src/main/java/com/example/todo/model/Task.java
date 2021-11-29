package com.example.todo.model;

import com.example.todo.enums.ETaskStatus;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {
   @Id
   private int id;
   private String name;
   private String startHour;
   private String endHour;
   private ETaskStatus status;

   public Task() {
   }

   public Task(int id, String name, String startHour, String endHour, ETaskStatus status) {
      this.id = id;
      this.name = name;
      this.startHour = startHour;
      this.endHour = endHour;
      this.status = status;
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

   public String getStartHour() {
      return startHour;
   }

   public void setStartHour(String startHour) {
      this.startHour = startHour;
   }

   public String getEndHour() {
      return endHour;
   }

   public void setEndHour(String endHour) {
      this.endHour = endHour;
   }

   public ETaskStatus getStatus() {
      return status;
   }

   public void setStatus(ETaskStatus status) {
      this.status = status;
   }
}
