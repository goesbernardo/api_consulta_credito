package com.goesbernardo.api_cartao;

import com.goesbernardo.api_cartao.entity.Credito;
import com.goesbernardo.api_cartao.repository.CreditoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@ComponentScan(basePackages = "com.goesbernardo.api_cartao")
public class ApiCartaoApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiCartaoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(CreditoRepository repository) {
//		return args -> {
//			// Criando uma entidade Credito e salvando no banco
//			Credito credito = new Credito();
//			credito.setNumeroCredito("CRED123");
//			credito.setNumeroNfse("NFSE456");
//			credito.setDataConstituicao(LocalDate.of(2024, 3, 14));
//			credito.setValorIssqn(BigDecimal.valueOf(1000.50));
//			credito.setTipoCredito("ISSQN");
//			credito.setSimplesNacional(true);
//			credito.setAliquota(BigDecimal.valueOf(5.00));
//			credito.setValorFaturado(BigDecimal.valueOf(20000.00));
//			credito.setValorDeducao(BigDecimal.valueOf(5000.00));
//			credito.setBaseCalculo(BigDecimal.valueOf(15000.00));
//
//			// Salvando no banco
//			repository.save(credito);
//		};

	}

