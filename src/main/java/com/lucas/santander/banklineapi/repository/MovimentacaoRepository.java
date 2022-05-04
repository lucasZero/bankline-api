package com.lucas.santander.banklineapi.repository;

import com.lucas.santander.banklineapi.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{
    
}
