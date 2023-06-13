package org.example.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.ProductEntity;
import org.example.model.Product;
import org.example.repos.BookRepos;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    public List<ProductEntity> list();

    public void saveProduct(Product product);

    public ProductEntity getProductById(Long id);

    public void deleteProduct(Long id);

}
