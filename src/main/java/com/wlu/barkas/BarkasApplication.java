package com.wlu.barkas;

import com.wlu.barkas.controllers.ApplicationContextProvider;
import com.wlu.barkas.domain.attributes.Manufacturer;
import com.wlu.barkas.domain.products.Engine;
import com.wlu.barkas.services.EngineService;
import com.wlu.barkas.services.ManufacturerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BarkasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarkasApplication.class, args);
		ManufacturerService manufacturerServiceImpl = ApplicationContextProvider.getApplicationContext().getBean(ManufacturerService.class);
		manufacturerServiceImpl.addManufacturer("man1", "Spain");
		List<Manufacturer> res = manufacturerServiceImpl.findManufacturerByCountry("Spain");
		res.forEach((manufacturer -> System.out.println(manufacturer)));
		EngineService service =  ApplicationContextProvider.getApplicationContext().getBean(EngineService.class);
		List<Engine> res2 = service.findEngineByCountry("Spain");
		res2.forEach((manufacturer -> System.out.println(manufacturer)));

	}
}
