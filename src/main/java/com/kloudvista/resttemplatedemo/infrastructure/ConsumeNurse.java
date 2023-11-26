package com.kloudvista.resttemplatedemo.infrastructure;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ConsumeNurse {
    @Autowired
    RestTemplate restTemplate;


    public Response getNurseDtoList() {
        String url = "http://localhost:9081/api/nurse/get-all";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);



        Response forEntity = restTemplate.getForObject(url, Response.class, entity);
        return  forEntity;

        /**
         *
         return   restTemplate.exchange(url, HttpMethod.GET,  entity, Response.class)
         .getBody();
        ResponseEntity<Response> forEntity = restTemplate.getForEntity(url, Response.class, entity);
        Response body = forEntity.getBody();
        return body; **/
    }

    public Response getNurseById(@PathVariable int id) {
        String url = "http://localhost:9081/api/nurse/get-by-id/{id}";

        Response forEntity = restTemplate.getForObject(url, Response.class, id);
        return  forEntity;
    }

    public void updateNurse(int id, Nurse nurse) {
      String url = "http://localhost:9081/api/nurse/update/{id}";
      restTemplate.put(url, nurse,UpdateResponse.class, Map.of(id, 1));
     return ;
    }

    public UpdateResponse createNurse(Nurse nurse) {

        String url = "http://localhost:9081/api/nurse/save";
        ResponseEntity<UpdateResponse> forEntity =
                restTemplate
                        .postForEntity(url, nurse, UpdateResponse.class );
        return forEntity.getBody();
    }
}
