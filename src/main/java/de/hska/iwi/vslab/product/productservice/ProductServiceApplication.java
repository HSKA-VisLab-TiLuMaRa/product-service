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
		productRepository.save(new Product(1000L,"Alice"));
		productRepository.save(new Product(1001L,"Bob"));
	}

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}