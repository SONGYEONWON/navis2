package com.lgcns.navis2.sample.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SampleDTO {
    private int seq;
    private String type;
    private String currency;
    @Min(0)
    private int price;
    private String etc;

}
