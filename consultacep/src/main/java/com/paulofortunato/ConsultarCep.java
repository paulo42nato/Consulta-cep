package com.paulofortunato;

import com.google.gson.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarCep {

    public Endereco buscaCEP(String cep) {
        URI enderecoAPICep = URI.create("https://viacep.com.br/ws/" + cep + "/json/");
        HttpRequest request = HttpRequest.newBuilder().uri(enderecoAPICep).build(); //Requisição da api viacep
        
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString()); //Resposta da api
            return new Gson().fromJson(response.body(), Endereco.class); //Convertendo e retornando resposta json em String
        } 
        catch (Exception e) {
            System.out.println("O CEP digitado é invalido!");
        }

        return null;
    }
}