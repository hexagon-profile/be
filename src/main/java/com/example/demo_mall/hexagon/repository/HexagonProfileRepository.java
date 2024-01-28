package com.example.demo_mall.hexagon.repository;

import com.example.demo_mall.hexagon.dto.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HexagonProfileRepository extends JpaRepository<Profile, Integer> {
}
