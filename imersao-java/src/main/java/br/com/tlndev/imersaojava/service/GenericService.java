package br.com.tlndev.imersaojava.service;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.imageio.ImageIO;

import br.com.tlndev.imersaojava.exceptions.ImersaoException;

public class GenericService {
	
	public GenericService() {
		geraDiretorio();
	}
 
	public String geraJson(String url) {
		try {
			URI link = URI.create(url);
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(link).GET().build();
			HttpResponse<String> response;
			response = client.send(request, BodyHandlers.ofString());
			return response.body();
		} catch (IOException | InterruptedException e) {
			throw new ImersaoException("Não foi possível criar JSON");
		}
	}
	
	public void geraSticker(String url, int novaAltura, String titulo, Double nota) {
		if(linkValido(url)) {
			try {
				BufferedImage imgOriginal = ImageIO.read(URL.of(URI.create(url), null)); 
				
				int alturaFinal = imgOriginal.getHeight()+novaAltura;
				int larguraFinal = imgOriginal.getWidth();
				BufferedImage imgAlterada = new BufferedImage(larguraFinal, alturaFinal, BufferedImage.TRANSLUCENT);
				
				Graphics2D graphics = (Graphics2D) imgAlterada.getGraphics();
				graphics.drawImage(imgOriginal, 0, 0, null);
				
				Font fonte = new Font("Impact", Font.BOLD, 64);
				graphics.setColor(Color.BLACK);
				graphics.setFont(fonte);
				
				FontMetrics metrics = graphics.getFontMetrics(fonte);
				String meme = "";
				BufferedImage selo = null;
				if(nota > 9) {
					meme = "TOPZAO";
					selo = ImageIO.read(new File("src/main/resources/images/input/lips-eyes.png"));
				} if(nota <= 9 && nota >= 7) {
					meme = "VERY BOM";
					selo = ImageIO.read(new File("src/main/resources/images/input/shrek.png"));
				} if(nota < 7 && nota >= 5)
					meme = "DA PRO GASTO KEK";
				if(nota < 5 && nota >= 0)
					meme = "BUUUUUUUUUU!!!";
				
				int alturaTexto = alturaFinal-(novaAltura/2);
				int larguraTexto = (larguraFinal-metrics.stringWidth(meme))/2;
				graphics.drawImage(selo, 0, alturaTexto, null);
				
				FontRenderContext frc = graphics.getFontRenderContext();
				TextLayout txtLayout = new TextLayout(meme, fonte, frc);
				Shape shape = txtLayout.getOutline(null);
				
				AffineTransform transform = graphics.getTransform();
				transform.translate(larguraTexto, alturaTexto);
				graphics.setTransform(transform);
				
				graphics.setStroke(new BasicStroke(larguraFinal * 0.005f));
				graphics.draw(shape);
				graphics.setColor(Color.YELLOW);
				graphics.fill(shape);
				
				graphics.drawString(meme, larguraTexto, alturaTexto);
				
				ImageIO.write(imgAlterada, "png", new File("src/main/resources/images/output/"+titulo+".png"));
			} catch (IOException e) {
				throw new ImersaoException("Não foi possível criar imagem");
			}
		} 
	}
	
	public void geraImagemBasica(String url, String titulo) {
		if(linkValido(url)) {
			try {
				BufferedImage imagem = ImageIO.read(URL.of(URI.create(url), null));
				ImageIO.write(imagem, "png", new File("src/main/resources/images/output/"+titulo+".png"));
			} catch (IOException e) {
				throw new ImersaoException("Não foi possível criar imagem");
			} 
		}
	}
	
	private boolean linkValido(String url) {
		if(url.toLowerCase().contains(".jpg") || url.toLowerCase().contains(".png"))
			return true;
		else {
			System.err.println("Não é possível criar uma imagem com o link: "+url);
			return false;
		}
	}
	
	private void geraDiretorio() {
		File dirOutputFotos = new File("src/main/resources/images/output");
		if(!dirOutputFotos.exists()) {
			dirOutputFotos.mkdirs();
		}
	}
	
}
