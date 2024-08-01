package com.paulofortunato;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner busca = new Scanner(System.in);
        ConsultarCep consultacep = new ConsultarCep();
        List<Endereco> enderecos = new ArrayList<>();
        String cond = "s";
        

        while (cond.equalsIgnoreCase("s")) {
            System.out.println("==============\n Consulta cep \n============== \n Digite o cep:  ");
            String cep = busca.nextLine();

        try {
            Endereco novoEndereco = consultacep.buscaCEP(cep);
            System.out.println(novoEndereco);
            
            enderecos.add(novoEndereco);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao realizar a consulta.\nVerifique se o CEP está correto!");
        }
        System.out.println("Iniciar uma nova consulta?");
        cond = busca.nextLine();
        }

        GerarJson gerar = new GerarJson();
        gerar.gerarJson(enderecos);
        busca.close();
    }
}