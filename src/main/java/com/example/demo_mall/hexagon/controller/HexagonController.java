package com.example.demo_mall.hexagon.controller;

import com.example.demo_mall.hexagon.dto.Profile;
import com.example.demo_mall.hexagon.service.HexagonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/hexagon")
@RequiredArgsConstructor
@RestController
public class HexagonController {

    private final HexagonService hexagonService;

    @GetMapping("/profile/{id}")
    public Profile getProfile(@PathVariable(name = "id") String id) {
        Profile profile = hexagonService.getProfile(Integer.parseInt(id));
        return profile;
    }

    @PostMapping("/profile")
    public Profile createProfile(@RequestBody Profile profile) {
        return hexagonService.createProfile(profile);
    }
}
