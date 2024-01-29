package com.example.hexagon.profile.entity;

import com.example.hexagon.profile.entity.Participant;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "profile")
@Data
public class Profile {

  @Id
  @Column(name = "profile_id")
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

  @OneToMany(mappedBy = "profile")
  @JsonManagedReference
  private List<Participant> participants;

  @PrePersist
  protected void onCreate() {
    this.createDate = LocalDateTime.now();
  }
}
