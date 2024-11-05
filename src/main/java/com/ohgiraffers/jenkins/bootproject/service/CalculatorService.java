package com.ohgiraffers.jenkins.bootproject.service;

import com.ohgiraffers.jenkins.bootproject.dto.CalculatorDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int plusTwoNumbers(CalculatorDTO calculatorDTO) {
        return calculatorDTO.getNum1() + calculatorDTO.getNum2();
    }
}