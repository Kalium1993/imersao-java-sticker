package br.com.tlndev.imersaojava.constants;

public enum UriUtil {
	TOP_FILMES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"),
	FILMES_POPULARES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json"),
	TOP_SERIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json"),
	SERIES_POPULARES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json"),
	NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-03-25&start_date=2023-03-30"),
	LINGUAGEM("http://localhost:8080/linguagem/ranking");
	
	private String url;
	
	UriUtil(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
}
