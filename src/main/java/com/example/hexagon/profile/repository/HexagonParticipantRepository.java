package com.example.hexagon.profile.repository;

import com.example.hexagon.profile.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HexagonParticipantRepository extends JpaRepository<Participant, Long> {
}
