package com.goesbernardo.api_cartao.controller;

import com.goesbernardo.api_cartao.dto.CreditoDTO;
import com.goesbernardo.api_cartao.service.CreditoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CreditoController.class)
class CreditoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditoService mockCreditoService;

    @Test
    void testListarCreditos() throws Exception {
        final CreditoDTO creditoDTO = new CreditoDTO();
        creditoDTO.setNumeroCredito("numeroCredito");
        creditoDTO.setNumeroNfse("numeroNfse");
        creditoDTO.setDataConstituicao(LocalDate.of(2020, 1, 1));
        creditoDTO.setValorIssqn(new BigDecimal("0.00"));
        creditoDTO.setTipoCredito("tipoCredito");
        final List<CreditoDTO> creditoDTOS = List.of(creditoDTO);
        when(mockCreditoService.buscarTodos()).thenReturn(creditoDTOS);

        mockMvc.perform(get("/api/creditos")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testListarCreditos_CreditoServiceReturnsNoItems() throws Exception {
        when(mockCreditoService.buscarTodos()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/creditos")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testBuscarPorNumeroNfse() throws Exception {
        final CreditoDTO creditoDTO = new CreditoDTO();
        creditoDTO.setNumeroCredito("numeroCredito");
        creditoDTO.setNumeroNfse("numeroNfse");
        creditoDTO.setDataConstituicao(LocalDate.of(2020, 1, 1));
        creditoDTO.setValorIssqn(new BigDecimal("0.00"));
        creditoDTO.setTipoCredito("tipoCredito");
        when(mockCreditoService.buscarPorNumeroNfse("numeroNfse")).thenReturn(creditoDTO);

        mockMvc.perform(get("/api/creditos/{numeroNfse}", "numeroNfse")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void testBuscarCreditoPorNumero() throws Exception {
        final CreditoDTO creditoDTO1 = new CreditoDTO();
        creditoDTO1.setNumeroCredito("numeroCredito");
        creditoDTO1.setNumeroNfse("numeroNfse");
        creditoDTO1.setDataConstituicao(LocalDate.of(2020, 1, 1));
        creditoDTO1.setValorIssqn(new BigDecimal("0.00"));
        creditoDTO1.setTipoCredito("tipoCredito");
        final Optional<CreditoDTO> creditoDTO = Optional.of(creditoDTO1);
        when(mockCreditoService.buscarPorNumeroCredito("numeroCredito")).thenReturn(creditoDTO);

        mockMvc.perform(get("/api/creditos/credito/{numeroCredito}", "numeroCredito")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }




    @Test
    void testDeletar() throws Exception {
        mockMvc.perform(delete("/api/creditos/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(mockCreditoService).deletar(0L);
    }
}
