package com.isj.si.GestionClientBackend.repository;

import com.isj.si.GestionClientBackend.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByPhoneNumber (String phone);
    Client findByEmail(String email);
}
