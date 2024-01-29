package com.example.hexagon.profile.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "participant")
@Data
public class Participant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long participantId;
  private String participantName;
  private long status1;
  private long status2;
  private long status3;
  private long status4;
  private long status5;
  private long status6;
  private LocalDateTime createDate;
  @ManyToOne
  @JoinColumn(name = "profile_id", referencedColumnName = "profile_id")
  @JsonBackReference
  private Profile profile;

  @PrePersist
  protected void onCreate() {
    this.createDate = LocalDateTime.now();
  }

}
