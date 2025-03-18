package com.goesbernardo.api_cartao.service;

import com.goesbernardo.api_cartao.dto.CreditoDTO;
import com.goesbernardo.api_cartao.entity.Credito;
import com.goesbernardo.api_cartao.repository.CreditoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreditoService {

    private final CreditoRepository creditoRepository;
    private final ModelMapper modelMapper;



    public CreditoService(CreditoRepository creditoRepository, ModelMapper modelMapper ) {

        this.creditoRepository = creditoRepository;
        this.modelMapper = modelMapper;
    }

    public CreditoDTO salvarCredito(CreditoDTO creditoDTO) {
        Credito credito = modelMapper.map(creditoDTO, Credito.class);
        credito = creditoRepository.save(credito);
        return modelMapper.map(credito, CreditoDTO.class);
    }

    public List<CreditoDTO> buscarTodos() {
        List<Credito> creditos = creditoRepository.findAll();
        return creditos.stream()
                .map(credito -> modelMapper.map(credito, CreditoDTO.class))
                .collect(Collectors.toList());
    }

    public CreditoDTO buscarPorNumeroNfse(String numeroNfse) {
        Optional<Credito> credito = creditoRepository.findByNumeroNfse(numeroNfse);
        return credito.map(c -> modelMapper.map(c, CreditoDTO.class)).orElse(null);
    }

    public Optional<CreditoDTO> buscarPorNumeroCredito(String numeroCredito) {
        return creditoRepository.findByNumeroCredito(numeroCredito)
                .map(credito -> modelMapper.map(credito, CreditoDTO.class));
    }

    public void deletar(Long id) {
        creditoRepository.deleteById(id);
    }



}
