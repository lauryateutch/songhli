package com.isj.si.GestionClientBackend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "situation_matrimoniale")
@Data
@NoArgsConstructor
public class MaritalStatus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private  String status;

    @OneToMany(targetEntity = Client.class, mappedBy = "status", fetch = FetchType.EAGER)
    private List <Client> client;
}
