package com.lucas.santander.banklineapi.controller;

import com.lucas.santander.banklineapi.dto.NovaMovimentacao;
import com.lucas.santander.banklineapi.model.Movimentacao;
import com.lucas.santander.banklineapi.repository.MovimentacaoRepository;
import com.lucas.santander.banklineapi.service.MovimentacaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Movimentacao")
public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository repository;
    
    @Autowired
    private MovimentacaoService service;
    
    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }
    
    @GetMapping("/{idConta}")
    public List<Movimentacao> findAll(@PathVariable("idConta") int idConta){
        return repository.findByIdConta(idConta);
    }
    
    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao){
        service.save(movimentacao);
    }
}
