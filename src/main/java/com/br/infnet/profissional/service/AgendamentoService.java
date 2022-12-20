package com.br.infnet.profissional.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient("agendamento")
public interface AgendamentoService {

    @GetMapping("buscarAgendaPorCliente")
    ResponseEntity<Map<String,Object>> buscarAgendaPorCliente(@RequestParam String cpf);

    @GetMapping("buscarAgenda")
    ResponseEntity<Map<String, Object>> buscarAgenda();

    @PostMapping("marcarServico")
    String marcarServico(@RequestParam String nomeCliente, @RequestParam String cpf, @RequestParam String dataAgendamento, @RequestParam String servico);

    @DeleteMapping("desmarcarServico")
    String desmarcarServico(@RequestParam Long id);
}
