package com.nikulin.springnetology.controller;

import com.nikulin.springnetology.Authorities;
import com.nikulin.springnetology.exception.InvalidCredentials;
import com.nikulin.springnetology.exception.UnauthorizedUser;
import com.nikulin.springnetology.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorizationController {

    @Autowired
    private AuthorizationService service = new AuthorizationService();

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidCredentials () {
        return "User name or password is empty";
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleUnauthorizedUser () {
        return "Unknown user";
    }
}
