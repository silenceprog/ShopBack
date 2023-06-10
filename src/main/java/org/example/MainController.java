package org.example;

import lombok.RequiredArgsConstructor;
import org.example.domain.Product;
import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ProductService productService;

    @GetMapping
    public String productInfo(@PathVariable Long id, Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "main";
    }

    @GetMapping("/")
    public String allData(Model model){
        model.addAttribute("products", productService.list());
        return "main";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("product/delete/{id}")
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
