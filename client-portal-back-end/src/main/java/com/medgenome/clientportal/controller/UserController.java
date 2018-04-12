package com.medgenome.clientportal.controller;


import com.medgenome.clientportal.model.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {



    @RequestMapping(value="/user", method = RequestMethod.GET)
    public AuthToken listUser(){
        return new AuthToken("hshhs", "mike","Patient");
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getOne(@PathVariable(value = "id") Long id){
        return "id"+" Useeer";
    }

}
