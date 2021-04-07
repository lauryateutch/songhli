package com.isj.si.GestionClientBackend.controller;

import com.isj.si.GestionClientBackend.dto.ClientCreateDto;
import com.isj.si.GestionClientBackend.entity.Client;
import com.isj.si.GestionClientBackend.services.ClientService;
import com.isj.si.GestionClientBackend.uploadingfiles.storage1.FilesStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;




@Controller
@RequestMapping("/client")
public class ClientController {

    private final Path root1 = Paths.get("upload");
    protected final Logger log = LoggerFactory.getLogger(ClientController.class);


    @Autowired
    private ClientService clientService;

    @Autowired
    private FilesStorageServiceImpl filesStorageService;



    //afficher le formulaire d'enregistrement du client
    @GetMapping("/register")
public ModelAndView getClientForm (){
        log.info("GET/client/register");
    final String viewName= "Client_form";
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("client",new ClientCreateDto());
        return new ModelAndView(viewName,model);


}



    @PostMapping("/register")
    public String  submitClientToTheBackend(@ModelAttribute("client")  ClientCreateDto clientCreateDto, @RequestParam("cni")  MultipartFile cni,
                                            @RequestParam ("photo") MultipartFile photo, @RequestParam ("location") MultipartFile location){
        log.info("POST/client/register called");

        Client client= new Client();
        client.setFirstName(clientCreateDto.getFirstName());
        client.setLastName(clientCreateDto.getLastName());
        client.setProfession(clientCreateDto.getProfession());
        client.setAddress(clientCreateDto.getAddress());
        client.setPhoneNumber(clientCreateDto.getPhoneNumber());
        client.setEmail(clientCreateDto.getEmail());
        client.setCni(cni.getOriginalFilename());
        client.setLocation(location.getOriginalFilename());
        client.setPhoto(photo.getOriginalFilename());
        client.setBirthday(clientCreateDto.getBirthday());

        if (Files.exists(this.root1.resolve(cni.getOriginalFilename())) == false) {
            filesStorageService.save(cni);
        }

        if (Files.exists(this.root1.resolve(photo.getOriginalFilename())) == false) {
            filesStorageService.save(photo);
        }

        if (Files.exists(this.root1.resolve(location.getOriginalFilename())) == false) {
            filesStorageService.save(location);
        }

        clientService.addClient(client);

            RedirectView redirectView= new RedirectView();
            redirectView.setUrl("/index");
            return "index";

    }


            //créer un compte bancaire
    @GetMapping("/resgisteraccount")
    public ModelAndView getAccountform (){

        log.info("GET/client/register");
        final String viewName= "Client_form";
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("client",new ClientCreateDto());
        return new ModelAndView(viewName,model);
    }
}

