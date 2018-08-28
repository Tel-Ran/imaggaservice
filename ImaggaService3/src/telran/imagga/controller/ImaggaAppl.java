package telran.imagga.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.imagga.dto.ImaggaRequest;
import telran.imagga.model.interfaces.IimaggaRun;
@SpringBootApplication
@RestController
@ComponentScan("telran.imagga.model.impl")
@CrossOrigin
public class ImaggaAppl {
@Autowired
IimaggaRun imagga;

@PostMapping("/tagging")
 String getTaggs(@RequestBody ImaggaRequest request) {
	return imagga.getResponse("/tagging",request.url,request.token);

}
@PostMapping("/colors")
 String getColorss(@RequestBody ImaggaRequest request) {
	return imagga.getResponse("/colors",request.url,request.token);

}
public static void main(String[] args) {
	SpringApplication.run
	(ImaggaAppl.class, args);
}

}
