package com.webvidhi.microservices.forex.conversionService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.webvidhi.microservices.forex.conversionService.config.RibonConfig;

@CrossOrigin
@RestController
public class CurrencyConvController {

	@LoadBalanced
    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
 
    @Autowired
    RestTemplate restTemplate;
	
    
	@GetMapping("convertCurrency/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion converCurrency(@PathVariable String from,@PathVariable String to ,@PathVariable BigDecimal quantity) {
		
		//send a query to forex-exchange and 
		

		Map<String, String> uriVars = new HashMap<>();
		uriVars.put("from", from);
		uriVars.put("to", to);

		ResponseEntity<CurrencyConversion> responseEntity = 
				restTemplate.getForEntity("http://FOREX-SERVICE/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVars);
		
		CurrencyConversion curConv = responseEntity.getBody();
		curConv.setToalConvertedAmount(curConv.getConversionMultiple().multiply(quantity));
		return new CurrencyConversion(curConv.getId(),curConv.getFrom(),curConv.getTo(),curConv.getConversionMultiple(),quantity,curConv.getToalConvertedAmount(),
				curConv.getPort());

	}
}
