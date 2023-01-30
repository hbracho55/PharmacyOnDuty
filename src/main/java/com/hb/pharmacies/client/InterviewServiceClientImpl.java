package com.hb.pharmacies.client;

import com.hb.pharmacies.dto.InterviewServiceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class InterviewServiceClientImpl implements InterviewServiceClient{

    private final RestTemplate restTemplate;

    @Autowired
    public InterviewServiceClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<InterviewServiceDto> getPharmacies() {

        try{
            List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
            messageConverters.add(converter);
            this.restTemplate.setMessageConverters(messageConverters);

            InterviewServiceDto[] pharmacies = restTemplate.getForObject("https://professionalinterviewservice.azurewebsites.net/api/GetEntries",
                    InterviewServiceDto[].class);
            return Arrays.asList(pharmacies);
        }catch(Exception e){
            log.error("Error retrieving data from InterviewService");
        }
        return null;
    }
}
