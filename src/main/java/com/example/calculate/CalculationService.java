package com.example.calculate;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    private final CalculationRepository calculationRepository;

    public CalculationService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public Integer calculate(CalculationType type, Integer x, Integer y) {
        switch (type) {
            case SUM:
                return x + y;
            case MULT:
                return x * y;
            default:
                throw new IllegalArgumentException("Calculation type: " + type);
        }
    }

    public Calculation save(CalculationType type, Integer x, Integer y, Integer result) {
        Calculation calculation = new Calculation(type, x, y, result);
        return calculationRepository.save(calculation);
    }
}

