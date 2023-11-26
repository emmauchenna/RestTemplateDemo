package com.kloudvista.resttemplatedemo.controller;

import com.kloudvista.resttemplatedemo.infrastructure.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    @Autowired
    ConsumeNurse consumeNurse;

    @RequestMapping(value = "/template/Nurses", method = RequestMethod.GET)
    public ResponseEntity<Response> getProductList() {
        Response nurseDtoList = consumeNurse.getNurseDtoList();
        return new ResponseEntity<>(nurseDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/template/by/{id}")
    public ResponseEntity<Response> getById(@PathVariable int id) {
        Response nurseDtoList = consumeNurse.getNurseById(id);
        return new ResponseEntity<>(nurseDtoList, HttpStatus.OK);
    }

    @PutMapping(value = "/template/update/{id}")
    public ResponseEntity
    updateNurse(@PathVariable int id, @RequestBody Nurse nurse){
        consumeNurse.updateNurse(id, nurse);
       return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping(value = "/template/save")
    public ResponseEntity<UpdateResponse>
    createNurse(@RequestBody Nurse nurse){
        UpdateResponse createResponse = consumeNurse.createNurse(nurse);
        return new ResponseEntity(createResponse, HttpStatus.CREATED);
    }
}
