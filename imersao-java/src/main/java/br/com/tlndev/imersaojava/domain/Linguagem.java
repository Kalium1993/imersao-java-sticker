package br.com.tlndev.imersaojava.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @JsonIgnoreProperties(ignoreUnknown = true)
public class Linguagem {
	private String titulo;
	private String imagem;
	private Double classificacao;
}
