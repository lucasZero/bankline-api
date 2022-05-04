package com.lucas.santander.banklineapi.repository;

import com.lucas.santander.banklineapi.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer>{
    
}
