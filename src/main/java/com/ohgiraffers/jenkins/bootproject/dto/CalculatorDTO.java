package com.ohgiraffers.jenkins.bootproject.dto;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class CalculatorDTO {
    @NonNull
    private Integer num1;
    @NonNull
    private Integer num2;
    private Integer sum;
}