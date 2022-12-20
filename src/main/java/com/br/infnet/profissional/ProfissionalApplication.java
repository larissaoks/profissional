package com.br.infnet.profissional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProfissionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfissionalApplication.class, args);
    }

}
