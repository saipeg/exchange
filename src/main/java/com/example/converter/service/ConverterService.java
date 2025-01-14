package com.example.converter.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConverterService {
    HttpClient client = HttpClientBuilder.create().build();
    HttpResponse response;

    public void getExchangeFor() {
        HttpGet request = new HttpGet("https://open.er-api.com/v6/latest/USD");


        {
            try {
                response = client.execute(request);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.print(response.getStatusLine());
    }

}
