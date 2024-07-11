package com.copy.copy_vesuviana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.copy.copy_vesuviana.model.Bnr;
import com.copy.copy_vesuviana.model.Macchina;

@SpringBootApplication
public class CopyVesuvianaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CopyVesuvianaApplication.class, args);
		 
		Macchina macchina = new Macchina();
        Bnr bnr = new Bnr();
        macchina.setBnr(bnr);
	}


    @Controller
	public class HomeController {
    	@GetMapping({"/","/home"})
    	public String home() {
        return "home";  // Questo cercherà il file home.html in src/main/resources/templates
    	}
	}



}
