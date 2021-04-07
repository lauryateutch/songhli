package com.isj.si.GestionClientBackend.services;


import com.isj.si.GestionClientBackend.dto.ClientDto;
import com.isj.si.GestionClientBackend.entity.Client;

import com.isj.si.GestionClientBackend.repository.ClientRepository;
import com.isj.si.GestionClientBackend.services.exceptions.ClientServiceException;
import com.isj.si.GestionClientBackend.services.exceptions.ExceptionMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    //@Autowired
    //private ClientMapper clientMapper;


    public ClientDto addClient (Client client) throws ClientServiceException{

        Client clientCheck= clientRepository.findByPhoneNumber(client.getPhoneNumber());
        if (clientCheck!=null){
            throw new ClientServiceException(ExceptionMessages.CLIENT_PHONE_ALREAY_USED, HttpStatus.UNPROCESSABLE_ENTITY);
        }

        clientCheck= clientRepository.findByEmail(client.getEmail());

        if (clientCheck!=null){
            throw new ClientServiceException(ExceptionMessages.CLIENT_EMAIL_ALREAY_USED, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        //Client client= clientMapper.toEntity(clientCreateDto);
        clientRepository.save(client);
        ClientDto clientDto= new ClientDto();
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setProfession(client.getProfession());
        clientDto.setAddress(client.getAddress());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        clientDto.setEmail(client.getEmail());
        clientDto.setCni(client.getCni());
        clientDto.setLocation(client.getLocation());
        clientDto.setPhoto(client.getPhoto());
        clientDto.setBirthday(client.getBirthday());

        return clientDto;

    }
}
