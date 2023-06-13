package org.example.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.ProductEntity;
import org.example.entity.UserEntity;
import org.example.model.Product;
import org.example.repos.BookRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final BookRepos bookRepos;

    @Override
    public List<ProductEntity> list() {
        List<ProductEntity> productEntities = bookRepos.findAll();
        return productEntities;
    }

    @Override
    public void saveProduct(Product product){
        log.info("Saving new{}", product);
        ProductEntity productEntity = ProductEntity.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .author(product.getAuthor())
                .pages(product.getPages())
                .date(product.getDate())
                .src(product.getSrc())
                .build();
        bookRepos.save(productEntity);
    }

    public ProductEntity getProductById(Long id){
        return bookRepos.findById(id).orElse(null);
    }

    public void deleteProduct(Long id){
        bookRepos.deleteById(id);
    }
}
