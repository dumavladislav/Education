package com.luv2com.springdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	@Value("${fortunes.filepath}")
	private String FILENAME;
	private List<String> fortunes;
	
	public FileFortuneService() {
		fortunes = new ArrayList<String>();
	}
	
	@PostConstruct
	public void cusomInit() {
		System.out.println(">> FileFortuneService: reading file");
		getFortunesFromFile();
		System.out.println(">> FileFortuneService: data loaded");
	}
	
	@Override
	public String getFortune() {
		Random rnd = new Random();
		return fortunes.get(rnd.nextInt(fortunes.size()));
	}
	
	private void getFortunesFromFile() {
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(FILENAME));
			String currentLine;
			while((currentLine = br.readLine()) != null) {
				fortunes.add(currentLine);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
