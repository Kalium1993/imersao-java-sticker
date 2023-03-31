package br.com.tlndev.imersaojava.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tlndev.imersaojava.domain.Linguagem;
import br.com.tlndev.imersaojava.exceptions.ImersaoException;

public class LinguagemService extends GenericService {
	
	public LinguagemService() {
		super();
	}
	
	public void geraListaLinguagens(String url) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			Linguagem linguagem[] = objMapper.readValue(geraJson(url), Linguagem[].class);
			
			for (int i = 0; i < linguagem.length; i++) {
				geraSticker(linguagem[i].getImagem(), 200, linguagem[i].getTitulo(), linguagem[i].getClassificacao());
			}
			
		} catch (JsonProcessingException e) {
			throw new ImersaoException("Não foi possível criar classe Linguagem");
		}
		
	}
 	
}
