package com.isj.si.GestionClientBackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="client_special")
@Data
@NoArgsConstructor
public class Client_special {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String  lastName;

    private String profession;

    private String address;

    private  String phoneNumber;

    private  String email;

   private  String cni;

   private String location;

   private String photo;

    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "idStatus")
    private MaritalStatus status;

    @OneToMany(targetEntity = Account.class, mappedBy = "client", fetch = FetchType.EAGER)
    private List<Account> accounts = new ArrayList<>();
}
