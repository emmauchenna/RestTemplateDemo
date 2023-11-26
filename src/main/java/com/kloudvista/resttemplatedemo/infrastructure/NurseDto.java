package com.kloudvista.resttemplatedemo.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NurseDto {

        public int id;
        public String firstName;
        public String lastName;
        public String phoneNumber;
        public String email;
        public boolean status;
        public BioDetail bioDetail;
        public ArrayList<Object> reference;

}
