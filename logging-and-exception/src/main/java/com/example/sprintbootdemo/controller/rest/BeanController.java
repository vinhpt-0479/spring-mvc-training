package com.example.sprintbootdemo.controller.rest;

import com.example.sprintbootdemo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BeanController {


    @Autowired
    private CalculatorService calculatorService;

    @GetMapping(value = "/bean/calculator/add", params = {"a", "b"})
    public ResponseEntity<Integer> add(
            @RequestParam(value = "a") int a,
            @RequestParam(value = "b") int b
    ) {
        return calculatorService.add(a, b);
    }

    @PostMapping(value = "/bean/calculator/add", consumes = "application/json")
    public ResponseEntity<Integer> postReqAdd(
            @RequestBody AddRequest addRequest
    ) {
        return calculatorService.add(addRequest.getA(), addRequest.getB());
    }

    @GetMapping(value = "/bean/calculator/subtract", params = {"a", "b"})
    public ResponseEntity<Integer> subtract(
            @RequestParam(value = "a") int a,
            @RequestParam(value = "b") int b
    ) {
        return calculatorService.subtract(a, b);
    }
}

class AddRequest {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
