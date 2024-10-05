package com.fipe.demo.controller;

import com.fipe.demo.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FipeController {
    @Autowired
    private FipeService fipeService;

    @GetMapping("/consultarMarcas")
    public String consultarMarcas() {
        return fipeService.consultarMarcas();
    }

    // Adicione endpoints para consultar modelos e anos, se necessário
}
