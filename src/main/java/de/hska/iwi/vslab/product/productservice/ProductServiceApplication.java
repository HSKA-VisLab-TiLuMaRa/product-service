package de.hska.iwi.vslab.product.productservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductServiceApplication {

	@Autowired
	private ProductRepo productRepository;

	@PostConstruct
	public void generateTestData() {
		productRepository.save(new Product(1000L,"Apfel", 10000, 2, "Eins tolle Banane!"));
		productRepository.save(new Product(1001L,"Gurke", 11000010, 1, "Die teuerste Gurke der Welt"));
	}

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
