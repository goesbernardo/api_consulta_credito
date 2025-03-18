package com.goesbernardo.api_cartao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CreditoDTO {

    @JsonProperty("numero_credito")
    private String numeroCredito;

    @JsonProperty("numero_nfse")
    private String numeroNfse;

    @JsonProperty("data_constituicao")
    private LocalDate dataConstituicao;

    @JsonProperty("valor_issqn")
    private BigDecimal valorIssqn;

    @JsonProperty("tipo_credito")
    private String tipoCredito;

    @JsonProperty("simples_nacional")
    private boolean simplesNacional;

    @JsonProperty("aliquota")
    private BigDecimal aliquota;

    @JsonProperty("valor_faturado")
    private BigDecimal valorFaturado;

    @JsonProperty("valor_deducao")
    private BigDecimal valorDeducao;

    @JsonProperty("base_calculo")
    private BigDecimal baseCalculo;
}
