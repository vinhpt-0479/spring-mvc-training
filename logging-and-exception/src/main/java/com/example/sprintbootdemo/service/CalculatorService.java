package com.example.sprintbootdemo.service;

import com.example.sprintbootdemo.component.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CalculatorService {
    @Autowired
    private Calculator calculator;

    public ResponseEntity<Integer> add(int a, int b) {
        return new ResponseEntity<>(calculator.add(a, b), HttpStatus.OK);
    }

    public ResponseEntity<Integer> subtract(int a, int b) {
        return new ResponseEntity<>(calculator.subtract(a, b), HttpStatus.OK);
    }

}
