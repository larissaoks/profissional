package com.br.infnet.profissional.controller;

import com.br.infnet.profissional.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ProfissionalController {

    @Autowired
    AgendamentoService agendamentoService;

    @GetMapping("buscarAgendaPorCliente")
    public ResponseEntity<Map<String,Object>> buscarAgendaPorCliente(@RequestParam String cpf){
        if(cpf.isEmpty() || cpf.equals(" ")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Error", "O cpf do cliente não foi preenchido!"));
        }
        ResponseEntity<Map<String,Object>> res = agendamentoService.buscarAgendaPorCliente(cpf);
        return ResponseEntity.ok(res.getBody());
    }

    @GetMapping("buscarAgenda")
    public ResponseEntity<Map<String,Object>> buscarAgenda(){
        ResponseEntity<Map<String,Object>> res = agendamentoService.buscarAgenda();
        if(res.getBody().isEmpty()){
            return ResponseEntity.ok(Map.of("Aviso: ", "Não há serviço agendado"));
        }
        return ResponseEntity.ok(res.getBody());
    }

    @PostMapping("marcarServico")
    public ResponseEntity<String> marcarServico(@RequestParam String nomeCliente, @RequestParam String cpf, @RequestParam String dataAgendamento, @RequestParam String servico){
        System.out.println("Servico marcado para " + nomeCliente + " dia: " + dataAgendamento);
        String res = agendamentoService.marcarServico(nomeCliente, cpf, dataAgendamento, servico);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("desmarcarServico")
    public ResponseEntity<String> desmarcarServico(@RequestParam Long id){
        String res = agendamentoService.desmarcarServico(id);
        return ResponseEntity.ok(res);
    }

}
