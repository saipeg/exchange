package com.example.converter.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ConverterService {
    HttpClient client = HttpClientBuilder.create().build();
    HttpResponse response;

    public int getExchangeForUSD() {
        HttpUriRequest request = new HttpGet("https://open.er-api.com/v6/latest/USD");

        {
            try {
                response = client.execute(request);
                var entity = response.getEntity();

                String currencies = EntityUtils.toString(entity);
                Pattern pattern = Pattern.compile("USD\":(.+?),");

                Matcher matcher = pattern.matcher(currencies);
                if (matcher.find()) {
                    return Integer.parseInt(matcher.group(1));
                }

            } catch (IOException e) {
                System.out.println("some went wrong");
                e.printStackTrace();
            }
        }

        return 0;
    }

}
