package br.com.tlndev.imersaojava;


import java.util.Scanner;

import br.com.tlndev.imersaojava.constants.UriUtil;
import br.com.tlndev.imersaojava.service.FilmeService;
import br.com.tlndev.imersaojava.service.LinguagemService;
import br.com.tlndev.imersaojava.service.NasaService;

public class ImersaoJavaApplication {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		String resposta = "";
		
		System.out.println("Deseja executar listas de filmes? (S/N)");
		resposta = kb.next();
		if(resposta.toUpperCase().equals("S")) {
			FilmeService filmeService = new FilmeService();
			filmeService.geraListaFilmes(UriUtil.TOP_FILMES.getUrl());
			filmeService.geraListaFilmesPopulares(UriUtil.FILMES_POPULARES.getUrl());
			filmeService.geraListaSeries(UriUtil.TOP_SERIES.getUrl());
			filmeService.geraListaSeriesPopulares(UriUtil.SERIES_POPULARES.getUrl());
		}
		
		System.out.println("Deseja executar imagens da NASA? (S/N)");
		resposta = kb.next();
		if(resposta.toUpperCase().equals("S")) {
			NasaService nasaService = new NasaService();
			nasaService.geraListaNasa(UriUtil.NASA.getUrl());
		}
		
		System.out.println("Deseja executar imagens das Linguagens? (S/N)");
		resposta = kb.next();
		if(resposta.toUpperCase().equals("S")) {
			LinguagemService linguagemService = new LinguagemService();
			linguagemService.geraListaLinguagens(UriUtil.LINGUAGEM.getUrl());
		}
		
	}

}
