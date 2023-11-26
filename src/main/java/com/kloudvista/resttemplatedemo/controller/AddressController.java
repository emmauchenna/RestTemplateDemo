package com.kloudvista.resttemplatedemo.controller;


import com.kloudvista.resttemplatedemo.infrastructure.address.AddressEndPoint;
import com.kloudvista.resttemplatedemo.infrastructure.address.ResGetAll;
import com.kloudvista.resttemplatedemo.infrastructure.address.ResponseAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressEndPoint addressEndPoint;

    @GetMapping("/template/get-addresses")
    public ResponseEntity<List<ResponseAddress>> getAddresses(){
      var addressList =  addressEndPoint.getAddresses();
      return new ResponseEntity(addressList, HttpStatus.OK);
    }

    @GetMapping("/template/get-add-by/{id}")
    public ResponseEntity<ResponseAddress> getAddresses(@PathVariable int id){
        var address =  addressEndPoint.getAddressById(id);
        return new ResponseEntity(address, HttpStatus.OK);
    }

    @PostMapping("/template/save-address")
    public ResponseEntity<ResponseAddress> getAddresses(@RequestBody ResponseAddress responseAddress){
        var address =  addressEndPoint.saveAddress(responseAddress);
        return new ResponseEntity(address, HttpStatus.OK);
    }

    @PutMapping("/template/update-address/{id}")
    public ResponseEntity getAddresses(@RequestBody ResponseAddress responseAddress, @PathVariable int id){
        addressEndPoint.updateAddress(responseAddress, id);
        return new ResponseEntity("Success", HttpStatus.OK);
    }


}
