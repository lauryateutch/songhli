package com.isj.si.GestionClientBackend.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "compte")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String contract;
    @NotEmpty
    private  Integer contractNumber;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
}
