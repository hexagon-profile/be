package com.example.hexagon.profile.controller;

import com.example.hexagon.profile.dto.ResAvgParticipantDto;
import com.example.hexagon.profile.entity.Participant;
import com.example.hexagon.profile.entity.Profile;
import com.example.hexagon.profile.service.HexagonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/hexagon")
@RequiredArgsConstructor
@RestController
public class HexagonController {

    private final HexagonService hexagonService;

    @GetMapping("/profile/{id}")
    public Profile getProfile(@PathVariable(name = "id") String id) {
        return hexagonService.getProfile(id);
    }

    @PostMapping("/profile")
    public Profile createProfile(@RequestBody Profile profile) {
        return hexagonService.createProfile(profile);
    }

    @GetMapping("/profile/{id}/participant")
    public List<Participant> getParticipantByProfileId(@PathVariable(name = "id") String id) {
        return hexagonService.getParticipantByProfileId(id);
    }

    @GetMapping("/profile/{id}/participant/avg")
    public ResAvgParticipantDto getAvgPoint(@PathVariable(name = "id") String id) {
        List<Double> participantAverage = hexagonService.getParticipantAverage(id);

        return ResAvgParticipantDto.builder()
                .profileId(id)
                .averagePoint(participantAverage)
                .build();
    }
}
