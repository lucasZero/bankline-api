package com.lucas.santander.banklineapi.service;

import com.lucas.santander.banklineapi.dto.NovaMovimentacao;
import com.lucas.santander.banklineapi.model.Correntista;
import com.lucas.santander.banklineapi.model.Movimentacao;
import com.lucas.santander.banklineapi.model.MovimentacaoTipo;
import com.lucas.santander.banklineapi.repository.CorrentistaRepository;
import com.lucas.santander.banklineapi.repository.MovimentacaoRepository;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {
    
    @Autowired
    private MovimentacaoRepository repository;
    
    @Autowired
    private CorrentistaRepository correntistaRepository;
    
    public void save(NovaMovimentacao novaMovimentacao){
        Movimentacao movimentacao = new Movimentacao();
        
        //Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor()*-1;
        
        Double valor = novaMovimentacao.getValor();
        if(novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA)
            valor = valor * -1;
        
        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);
        
        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if(correntista != null){
            Double saldo = correntista.getConta().getSaldo();
            correntista.getConta().setSaldo(saldo + valor);
            correntistaRepository.save(correntista);
        }
                
        repository.save(movimentacao);
    }
}
