package br.com.tlndev.imersaojava.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tlndev.imersaojava.domain.Catalogo;
import br.com.tlndev.imersaojava.domain.Filme;
import br.com.tlndev.imersaojava.exceptions.ImersaoException;

public class FilmeService extends GenericService {
	private final String s = "⭐";
	
	public FilmeService() {
		super();
	}
	
	public void geraListaFilmes(String url) {
		Catalogo catalogo = geraCatalogo(url);
		
		int contador = 0;
		System.out.println("\u001b[3m Catálogo de filmes: \u001b[m");
		for(Filme f : catalogo.getItems()) {
			String classificacao = "";
			contador += 1;
			
			System.out.println("\u001b[46m Filme "+contador+"\u001b[m");
			System.out.println("\u001b[1m Título: \u001b[m"+f.getTitle());
			System.out.println("\u001b[1m Poster: \u001b[m"+f.getImage());
			
			Double nota = Double.parseDouble(f.getImDbRating());
			int estrelas = nota.intValue();
			for(int n = 1; n <= estrelas; n++) {
				classificacao += s;
			}
			System.out.println("\u001b[1m Classificação: \u001b[m"+classificacao);
			
			geraSticker(f.getImage(), 200, f.getTitle(), nota);
		}
		System.out.println("\n");
	}
	
	public void geraListaFilmesPopulares(String url) {
		Catalogo catalogo = geraCatalogo(url);
		
		int contador = 0;
		System.out.println("\u001b[3m Catálogo de filmes mais populares: \u001b[m");
		for(Filme f : catalogo.getItems()) {
			String classificacao = "";
			contador += 1;
			
			System.out.println("\u001b[46m Filme "+contador+"\u001b[m");
			System.out.println("\u001b[1m Título: \u001b[m"+f.getTitle());
			System.out.println("\u001b[1m Poster: \u001b[m"+f.getImage());

			Double nota = Double.parseDouble(f.getImDbRating());
			int estrelas = nota.intValue();
			for(int n = 1; n <= estrelas; n++) {
				classificacao += s;
			}
			System.out.println("\u001b[1m Classificação: \u001b[m"+classificacao);
			
			geraSticker(f.getImage(), 200, f.getTitle(), nota);
		}
		System.out.println("\n");
	}
	
	public void geraListaSeries(String url) {
		Catalogo catalogo = geraCatalogo(url);
		
		int contador = 0;
		System.out.println("\u001b[3m Catálogo de séries: \u001b[m");
		for(Filme f : catalogo.getItems()) {
			String classificacao = "";
			contador += 1;
			
			System.out.println("\u001b[46m Série "+contador+"\u001b[m");
			System.out.println("\u001b[1m Título: \u001b[m"+f.getTitle());
			System.out.println("\u001b[1m Poster: \u001b[m"+f.getImage());
			
			Double nota = Double.parseDouble(f.getImDbRating());
			int estrelas = nota.intValue();
			for(int n = 1; n <= estrelas; n++) {
				classificacao += s;
			}
			System.out.println("\u001b[1m Classificação: \u001b[m"+classificacao);
			
			geraSticker(f.getImage(), 200, f.getTitle(), nota);
		}
		System.out.println("\n");
	}
	
	public void geraListaSeriesPopulares(String url) {
		Catalogo catalogo = geraCatalogo(url);
		
		int contador = 0;
		System.out.println("\u001b[3m Catálogo de séries mais populares: \u001b[m");
		for(Filme f : catalogo.getItems()) {
			String classificacao = "";
			contador += 1;
			
			System.out.println("\u001b[46m Série "+contador+"\u001b[m");
			System.out.println("\u001b[1m Título: \u001b[m"+f.getTitle());
			System.out.println("\u001b[1m Poster: \u001b[m"+f.getImage());
			
			Double nota = Double.parseDouble(f.getImDbRating());
			int estrelas = nota.intValue();
			for(int n = 1; n <= estrelas; n++) {
				classificacao += s;
			}
			System.out.println("\u001b[1m Classificação: \u001b[m"+classificacao);
			
			geraSticker(f.getImage(), 200, f.getTitle(), nota);
		}
	}
	
	private Catalogo geraCatalogo(String url) {
		ObjectMapper objMapper = new ObjectMapper();
		try {
			return objMapper.readValue(geraJson(url), Catalogo.class);
		} catch (JsonProcessingException e) {
			throw new ImersaoException("Não foi possível criar classe Catalogo");
		}
	}
	
	
}
