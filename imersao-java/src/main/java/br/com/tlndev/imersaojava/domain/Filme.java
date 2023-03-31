package br.com.tlndev.imersaojava.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @JsonIgnoreProperties(ignoreUnknown = true)
public class Filme {
	private String title;
	private String image;
	private String imDbRating;
}
