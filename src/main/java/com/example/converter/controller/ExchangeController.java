package com.example.converter.controller;

import com.example.converter.service.ConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    private final ConverterService converterService;

    public ExchangeController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @GetMapping("/exchange")
    public String getExchange() {
        converterService.getExchangeFor();
        return "расчет окончен";
    }
}
