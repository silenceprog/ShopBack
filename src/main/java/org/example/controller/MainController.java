package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.ProductEntity;
import org.example.model.Product;
import org.example.services.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductEntity productInfo(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    public List<ProductEntity> allData(){
        return productService.list();
    }

    @PostMapping("/create")
    public String createProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }


    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }

//    @GetMapping("/oddresult")
//    public String getOddNumbers(Map<String,Object> model){
//        List<Object[]> oddNumbers = streetRepos.findIdAndStreetName();
//        model.put("oddNumbers", oddNumbers);
//        return "result";
//    }
}
