package com.example.converter.controller;

import com.example.converter.service.ConverterService;
import com.example.converter.service.CurrencyNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    private static int counter = 0;
    private final ConverterService converterService;

    public ExchangeController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @GetMapping("/exchange")
    public String getExchange(@RequestParam("currency") String currency) {
        Double exchangeFor;
        try {
            exchangeFor = converterService.getExchangeFor(currency);
        } catch (CurrencyNotFoundException e) {
            counter++;
            return "Sorry, this currency: " + currency + "not found"
                    + "\n номер запроса: " + counter;
        }
        counter++;
        return "расчет окончен, значение выбранной валюты:" + currency + " в доллоровом эквиваленте: " + exchangeFor
                + "\n номер запроса: " + counter;
    }
}
