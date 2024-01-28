package com.example.demo_mall.hexagon.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "profile")
@Data
public class Profile {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long profileId;
  private String profileName;
  private long status1;
  private long status2;
  private long status3;
  private long status4;
  private long status5;
  private long status6;
  private LocalDateTime createDate;
  private LocalDateTime lastParticipantUpdateDate;

  @PrePersist
  protected void onCreate() {
    this.createDate = LocalDateTime.now();
  }
}
