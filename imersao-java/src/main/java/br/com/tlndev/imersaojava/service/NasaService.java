package br.com.tlndev.imersaojava.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tlndev.imersaojava.domain.Nasa;
import br.com.tlndev.imersaojava.exceptions.ImersaoException;

public class NasaService extends GenericService {
	
	public NasaService() {
		super();
	}
	
	public void geraListaNasa(String url) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			Nasa nasa[] = objMapper.readValue(geraJson(url), Nasa[].class);
			
			for (int i = 0; i < nasa.length; i++) {
				geraSticker(nasa[i].url(), 200, nasa[i].title(), 10.0);
			}
			
		} catch (JsonProcessingException e) {
			throw new ImersaoException("Não foi possível criar classe Nasa");
		} 
	}
	
}
