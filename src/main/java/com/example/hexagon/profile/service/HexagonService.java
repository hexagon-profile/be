package com.example.hexagon.profile.service;

import com.example.hexagon.common.exception.ProfileNotFoundException;
import com.example.hexagon.profile.entity.Participant;
import com.example.hexagon.profile.entity.Profile;
import com.example.hexagon.profile.repository.HexagonParticipantRepository;
import com.example.hexagon.profile.repository.HexagonProfileRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HexagonService {

    private final HexagonProfileRepository hexagonProfileRepository;

    private final HexagonParticipantRepository hexagonParticipantRepository;

    @Transactional
    public Profile getProfile(String id) {
        return hexagonProfileRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ProfileNotFoundException("Profile not found with id: " + id));
    }

    @Transactional
    public Profile createProfile(Profile profile) {
        return hexagonProfileRepository.save(profile);
    }

    @Transactional
    public List<Participant> getParticipantByProfileId(String id) {
        Profile profile = hexagonProfileRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ProfileNotFoundException("존재하지 않는 프로필입니다. id:" + id));
        return profile.getParticipants();
    }

    @Transactional
    public List<Double> getParticipantAverage(String id) {
        List<Participant> participants = getParticipantByProfileId(id);
        int count = participants.size();

        List<Double> averages = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));

        participants.forEach(p -> {
            averages.set(0, averages.get(0) + p.getStatus1());
            averages.set(1, averages.get(1) + p.getStatus2());
            averages.set(2, averages.get(2) + p.getStatus3());
            averages.set(3, averages.get(3) + p.getStatus4());
            averages.set(4, averages.get(4) + p.getStatus5());
            averages.set(5, averages.get(5) + p.getStatus6());
        });

        return averages.stream()
                .map(s -> Math.round(s * 10.0 / count) / 10.0)
                .collect(Collectors.toList());
    }

}
