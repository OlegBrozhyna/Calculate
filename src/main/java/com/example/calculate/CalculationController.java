package com.example.calculate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/calc")
public class CalculationController {
    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Integer>> calculate(
            @RequestParam CalculationType type,
            @RequestParam Integer x,
            @RequestParam Integer y
    ) {
        Integer result = calculationService.calculate(type, x, y);
        calculationService.save(type, x, y, result);
        Map<String, Integer> response = new HashMap<>();
        response.put("result", result);
        return ResponseEntity.ok(response);
    }
}

