package br.com.devmedia.blog.util;

import java.text.Normalizer;

public class MyReplaceString {
	public static String formatarPermalink(String value){

		//	Persistência com JPA! -> persistencia_com_jpa
		
		String link = value.trim();
		
		link = link.toLowerCase();
		
		link = Normalizer.normalize(link, Normalizer.Form.NFD);
		
		link = link.replaceAll("\\s", "_");//remove espaços
		
		link = link.replaceAll("\\W", "");//caracteres especiais não alfanumericos
		
		link = link.replaceAll("\\_+", "_");//remove +de um _
		
		return link;
		
	}
}
