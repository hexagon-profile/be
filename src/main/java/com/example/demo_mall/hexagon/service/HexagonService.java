package com.example.demo_mall.hexagon.service;

import com.example.demo_mall.common.exception.ProfileNotFoundException;
import com.example.demo_mall.hexagon.dto.Profile;
import com.example.demo_mall.hexagon.repository.HexagonProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HexagonService {

    private final HexagonProfileRepository hexagonRepository;

    public Profile getProfile(Integer id) {
        return hexagonRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found with id: " + id));
    }

    public Profile createProfile(Profile profile) {
        return hexagonRepository.save(profile);
    }




}
