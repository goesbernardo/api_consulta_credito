package com.goesbernardo.api_cartao.service;

import com.goesbernardo.api_cartao.dto.CreditoDTO;
import com.goesbernardo.api_cartao.entity.Credito;
import com.goesbernardo.api_cartao.repository.CreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreditoServiceTest {

    @Mock
    private CreditoRepository mockCreditoRepository;
    @Mock
    private ModelMapper mockModelMapper;

    private CreditoService creditoServiceUnderTest;

    @BeforeEach
    void setUp() {
        creditoServiceUnderTest = new CreditoService(mockCreditoRepository, mockModelMapper);
    }

    @Test
    void testSalvarCredito() {
        final CreditoDTO creditoDTO = new CreditoDTO();
        creditoDTO.setNumeroCredito("numeroCredito");
        creditoDTO.setNumeroNfse("numeroNfse");
        creditoDTO.setDataConstituicao(LocalDate.of(2020, 1, 1));
        creditoDTO.setValorIssqn(new BigDecimal("0.00"));
        creditoDTO.setTipoCredito("tipoCredito");

        final Credito credito = new Credito();
        credito.setId(0L);
        credito.setNumeroCredito("numeroCredito");
        credito.setNumeroNfse("numeroNfse");
        credito.setDataConstituicao(LocalDate.of(2020, 1, 1));
        credito.setValorIssqn(new BigDecimal("0.00"));
        when(mockModelMapper.map(any(Object.class), eq(Credito.class))).thenReturn(credito);

        final Credito credito1 = new Credito();
        credito1.setId(0L);
        credito1.setNumeroCredito("numeroCredito");
        credito1.setNumeroNfse("numeroNfse");
        credito1.setDataConstituicao(LocalDate.of(2020, 1, 1));
        credito1.setValorIssqn(new BigDecimal("0.00"));
        final Credito entity = new Credito();
        entity.setId(0L);
        entity.setNumeroCredito("numeroCredito");
        entity.setNumeroNfse("numeroNfse");
        entity.setDataConstituicao(LocalDate.of(2020, 1, 1));
        entity.setValorIssqn(new BigDecimal("0.00"));
        when(mockCreditoRepository.save(entity)).thenReturn(credito1);

        final CreditoDTO result = creditoServiceUnderTest.salvarCredito(creditoDTO);

    }

    @Test
    void testBuscarTodos() {
        final Credito credito = new Credito();
        credito.setId(0L);
        credito.setNumeroCredito("numeroCredito");
        credito.setNumeroNfse("numeroNfse");
        credito.setDataConstituicao(LocalDate.of(2020, 1, 1));
        credito.setValorIssqn(new BigDecimal("0.00"));
        final List<Credito> creditos = List.of(credito);
        when(mockCreditoRepository.findAll()).thenReturn(creditos);

        final CreditoDTO creditoDTO = new CreditoDTO();
        creditoDTO.setNumeroCredito("numeroCredito");
        creditoDTO.setNumeroNfse("numeroNfse");
        creditoDTO.setDataConstituicao(LocalDate.of(2020, 1, 1));
        creditoDTO.setValorIssqn(new BigDecimal("0.00"));
        creditoDTO.setTipoCredito("tipoCredito");
        final Credito source = new Credito();
        source.setId(0L);
        source.setNumeroCredito("numeroCredito");
        source.setNumeroNfse("numeroNfse");
        source.setDataConstituicao(LocalDate.of(2020, 1, 1));
        source.setValorIssqn(new BigDecimal("0.00"));
        when(mockModelMapper.map(source, CreditoDTO.class)).thenReturn(creditoDTO);

        final List<CreditoDTO> result = creditoServiceUnderTest.buscarTodos();

    }

    @Test
    void testBuscarTodos_CreditoRepositoryReturnsNoItems() {
        when(mockCreditoRepository.findAll()).thenReturn(Collections.emptyList());

        final List<CreditoDTO> result = creditoServiceUnderTest.buscarTodos();

        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testBuscarPorNumeroNfse() {
        final Credito credito1 = new Credito();
        credito1.setId(0L);
        credito1.setNumeroCredito("numeroCredito");
        credito1.setNumeroNfse("numeroNfse");
        credito1.setDataConstituicao(LocalDate.of(2020, 1, 1));
        credito1.setValorIssqn(new BigDecimal("0.00"));
        final Optional<Credito> credito = Optional.of(credito1);
        when(mockCreditoRepository.findByNumeroNfse("numeroNfse")).thenReturn(credito);

        final CreditoDTO creditoDTO = new CreditoDTO();
        creditoDTO.setNumeroCredito("numeroCredito");
        creditoDTO.setNumeroNfse("numeroNfse");
        creditoDTO.setDataConstituicao(LocalDate.of(2020, 1, 1));
        creditoDTO.setValorIssqn(new BigDecimal("0.00"));
        creditoDTO.setTipoCredito("tipoCredito");
        final Credito source = new Credito();
        source.setId(0L);
        source.setNumeroCredito("numeroCredito");
        source.setNumeroNfse("numeroNfse");
        source.setDataConstituicao(LocalDate.of(2020, 1, 1));
        source.setValorIssqn(new BigDecimal("0.00"));
        when(mockModelMapper.map(source, CreditoDTO.class)).thenReturn(creditoDTO);

        final CreditoDTO result = creditoServiceUnderTest.buscarPorNumeroNfse("numeroNfse");

    }

    @Test
    void testBuscarPorNumeroNfse_CreditoRepositoryReturnsAbsent() {
        when(mockCreditoRepository.findByNumeroNfse("numeroNfse")).thenReturn(Optional.empty());

        final CreditoDTO result = creditoServiceUnderTest.buscarPorNumeroNfse("numeroNfse");

        assertThat(result).isNull();
    }

    @Test
    void testBuscarPorNumeroCredito() {
        final Credito credito1 = new Credito();
        credito1.setId(0L);
        credito1.setNumeroCredito("numeroCredito");
        credito1.setNumeroNfse("numeroNfse");
        credito1.setDataConstituicao(LocalDate.of(2020, 1, 1));
        credito1.setValorIssqn(new BigDecimal("0.00"));
        final Optional<Credito> credito = Optional.of(credito1);
        when(mockCreditoRepository.findByNumeroCredito("numeroCredito")).thenReturn(credito);

        final CreditoDTO creditoDTO = new CreditoDTO();
        creditoDTO.setNumeroCredito("numeroCredito");
        creditoDTO.setNumeroNfse("numeroNfse");
        creditoDTO.setDataConstituicao(LocalDate.of(2020, 1, 1));
        creditoDTO.setValorIssqn(new BigDecimal("0.00"));
        creditoDTO.setTipoCredito("tipoCredito");
        final Credito source = new Credito();
        source.setId(0L);
        source.setNumeroCredito("numeroCredito");
        source.setNumeroNfse("numeroNfse");
        source.setDataConstituicao(LocalDate.of(2020, 1, 1));
        source.setValorIssqn(new BigDecimal("0.00"));
        when(mockModelMapper.map(source, CreditoDTO.class)).thenReturn(creditoDTO);

        final Optional<CreditoDTO> result = creditoServiceUnderTest.buscarPorNumeroCredito("numeroCredito");

    }

    @Test
    void testBuscarPorNumeroCredito_CreditoRepositoryReturnsAbsent() {
        when(mockCreditoRepository.findByNumeroCredito("numeroCredito")).thenReturn(Optional.empty());

        final Optional<CreditoDTO> result = creditoServiceUnderTest.buscarPorNumeroCredito("numeroCredito");

        assertThat(result).isEmpty();
    }

    @Test
    void testDeletar() {
        creditoServiceUnderTest.deletar(0L);

        verify(mockCreditoRepository).deleteById(0L);
    }
}
