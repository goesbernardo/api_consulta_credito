package com.goesbernardo.api_cartao.repository;

import com.goesbernardo.api_cartao.entity.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditoRepository extends JpaRepository<Credito,Long> {

    Optional<Credito> findByNumeroNfse(String numeroNfse);

    Optional<Credito> findByNumeroCredito(String numeroCredito);



}
