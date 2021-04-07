package com.isj.si.GestionClientBackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@ToString
public class ClientDto {
    private String firstName;

    private String  lastName;

    private String profession;

    private String address;

    private  String phoneNumber;

    private  String email;

    private String cni;

    private String location;

    private String photo;

    private Date birthday;
}
