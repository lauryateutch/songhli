package com.isj.si.GestionClientBackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class ClientCreateDto {


    private String firstName;

    private String lastName;

    private String profession;

    private String address;

    private  String email;

    private  String phoneNumber;

    private Date birthday;

}
