package com.kloudvista.resttemplatedemo.infrastructure.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseAddress {
        public int id;
        public String street;
        public String street_2;
        public String city;
        public String stateProvince;
        public String country;
        public String registrationNo;
       // public String addressType;
}
