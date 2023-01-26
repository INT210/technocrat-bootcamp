package com.example.springboot.externa;

import com.example.springboot.externa.DTO.EventBriteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
//import java.net.http.HttpHeaders;

public class EventbriteHelper {
    @Autowired private RestTemplate restTemplate;
    public EventBriteDTO fetchEventsByOrganization(String organizationId) throws Exception {
        String url = "https://www.eventbriteapi.com/v3/organizations/" + organizationId + "/events/";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorzation", "Bearer QMFZ33AZTC4GEMHEQQUT");
        HttpEntity<EventBriteDTO> entity = new HttpEntity<EventBriteDTO>(httpHeaders);
        return restTemplate.exchange(url, HttpMethod.GET, entity, EventBriteDTO.class).getBody();
    }
}
