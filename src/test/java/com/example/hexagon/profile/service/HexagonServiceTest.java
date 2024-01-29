package com.example.hexagon.profile.service;

import com.example.hexagon.profile.repository.HexagonProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest(classes = {HexagonService.class, HexagonProfileRepository.class})
@SpringBootTest
class HexagonServiceTest {


    @Autowired
    HexagonService hexagonService;

    @Autowired
    HexagonProfileRepository hexagonProfileRepository;

    @Test
    void getParticipantAverage() {
        //given
        String profileId = "2";

        //when
        List<Double> participantAverage = hexagonService.getParticipantAverage(profileId);

        //then
        System.out.println("participantAverage = " + participantAverage);
        assertThat(participantAverage).containsExactly(4.0,6.0,7.0,8.0,7.0,6.0);
    }

}