package com.fipe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FipeService {
    private final RestTemplate restTemplate;

    @Value("${fipe.api.url}")
    private String apiUrl;

    @Autowired
    public FipeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private String consultarURL(String apiUrl) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            throw new RuntimeException("Falha ao obter dados. Código de status: " + responseEntity.getStatusCode());
        }
    }

    public String consultarMarcas() {
        return consultarURL(apiUrl + "/carros/marcas");
    }

    // Adicione métodos para consultar modelos e anos, se necessário
    // Baseie-se na documentação da API para implementar essas funcionalidades
}
