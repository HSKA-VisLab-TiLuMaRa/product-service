package de.hska.iwi.vslab.product.productservice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepo extends CrudRepository<Product, Long> { 
    @Query("SELECT t FROM Product t where t.name = :name") 
    Iterable<Product> findProductsByName(@Param("name") String name);

    @Query("SELECT t FROM Product t where t.categoryId = :categoryId") 
    Iterable<Product> findProductsByCategory(@Param("categoryId") Integer categoryId);
}