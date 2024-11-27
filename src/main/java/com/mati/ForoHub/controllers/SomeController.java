package com.mati.ForoHub.controllers;

import com.mati.ForoHub.services.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/protected")  // Ruta protegida
public class SomeController {

    @Autowired
    private SomeService someService;

    // Ejemplo de solicitud GET que requiere autenticación
    @GetMapping("/data")
    @PreAuthorize("hasRole('USER')")  // Asegura que solo usuarios con rol 'USER' puedan acceder
    public List<String> getData(@AuthenticationPrincipal User user) {
        // Ejemplo de lógica para manejar la solicitud GET
        return someService.getSomeData(user.getUsername());
    }
}

