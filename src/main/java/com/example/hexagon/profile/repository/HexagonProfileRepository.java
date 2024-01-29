package com.example.hexagon.profile.repository;

import com.example.hexagon.profile.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HexagonProfileRepository extends JpaRepository<Profile, Long> {
}
