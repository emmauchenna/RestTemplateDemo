package com.kloudvista.resttemplatedemo.infrastructure.address;


import com.kloudvista.resttemplatedemo.infrastructure.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class AddressEndPoint {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${host.address}")
    private String hostAddress;

    public ResponseAddress getAddressById(long id){
        String url = "http://localhost:9081/address/get-address-by/{id}";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-LOCATION", "USA");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

       ResponseEntity<ResponseAddress> response = restTemplate.getForEntity(url, ResponseAddress.class, id);
        if(response.hasBody())
          return   response.getBody();
        return null;

        /**


         ResponseAddress forObject = restTemplate.getForObject(url, ResponseAddress.class, id);
        return forObject;



        ResponseEntity<ResponseAddress> response = restTemplate.exchange(url + "/" + id, HttpMethod.GET, entity, ResponseAddress.class);
        if(response.hasBody())
            return   response.getBody();
        return null;

        **/
    }

    public List<ResponseAddress> getAddresses(){
        String url = hostAddress+"/address/get-all";

        log.info("Print out url: "+url);

        HttpHeaders headers = new HttpHeaders();

        headers.set("X-COM-LOCATION", "USA");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseAddress[] forObject = restTemplate.getForObject(url, ResponseAddress[].class, entity);
        List<ResponseAddress> responseAddresses = Arrays.asList(forObject);
        return responseAddresses;
    }

    public String saveAddress(ResponseAddress object){
        String url = "http://localhost:9081/address/save";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-LOCATION", "USA");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        String response = restTemplate.postForObject(url, object, String.class);
        return response;
    }

    public void updateAddress(ResponseAddress responseAddress, int id) {
        String url = "http://localhost:9081/address/save";
        restTemplate.put(url, responseAddress, id );
    }
}
