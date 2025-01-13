package com.juradogonzalezrodrigo.literalura;

import com.juradogonzalezrodrigo.literalura.principal.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	private final MainMenu mainMenu;

	@Autowired
	public LiteraluraApplication(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mainMenu.iniciarMenu();
	}
}
