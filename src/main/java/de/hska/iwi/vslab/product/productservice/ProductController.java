 
package de.hska.iwi.vslab.product.productservice;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProductController {

	@Autowired
	private ProductRepo repo;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Product>> getProducts(@RequestParam Optional<String> name, @RequestParam Optional<Integer> categoryId) {
		Iterable<Product> allPolls;
		if (name.isPresent()){
			allPolls = repo.findProductsByName(name.get());
		} else if (categoryId.isPresent()) {
			allPolls = repo.findProductsByCategory(categoryId.get());
		} else {
			allPolls = repo.findAll();
		}    
		return new ResponseEntity<Iterable<Product>>(allPolls, HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		product = repo.save(product);
		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newProductUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId())
				.toUri();
		responseHeaders.setLocation(newProductUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
		Product product = repo.findById(productId).orElse(null);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProduct(@RequestBody Product product) {
		product = repo.save(product);
		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newProductUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId())
				.toUri();
		responseHeaders.setLocation(newProductUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteUser(@PathVariable Long productId) {
		repo.deleteById(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
