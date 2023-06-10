package org.example.services;

import org.example.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID,"Table","Wooden table",4173.30,"Kiev","George"));
        products.add(new Product(++ID,"Monitor","Monitor",2399.00,"Lviv","nonames"));
    }

    public List<Product> list() {return products;}


    public void saveProduct(Product product){
        product.setId(++ID);
        products.add(product);
    }

    public Product getProductById(Long id){
        for (Product product : products) {
            if (product.getId().equals(id))return product;
        }
        return null;
    }

    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

}
