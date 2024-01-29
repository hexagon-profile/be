package com.example.hexagon.profile.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResAvgParticipantDto {
    private String profileId;
    private List<Double> averagePoint;
}
