package telran.imagga.model.impl;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import telran.imagga.model.interfaces.IimaggaRun;
@Service
public class ImaggaRun implements IimaggaRun {

	@Override
	public String getResponse(String endPoint, String urlImage, String token) {
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.add("Authorization",
				token);
		String url=endPoint.contains("colors")?
				"https://api.imagga.com/v1/colors?url=":"https://api.imagga.com/v1/tagging?url=";
		
		HttpEntity<String> requestEntity=new HttpEntity<>(headers);
		ResponseEntity<String> response=
				restTemplate.exchange
				(url+urlImage, HttpMethod.GET, requestEntity, String.class);
		return response.getBody();
	}

	
}
