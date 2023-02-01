package org.example;

import org.example.domain.Street;
import org.example.repos.StreetRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private StreetRepos streetRepos;

    @GetMapping("/")
    public String allData(Map<String,Object> model){
        Iterable<Street> streets = streetRepos.findAll();
        model.put("streets", streets);
        return "main";
    }

    @GetMapping("/oddresult")
    public String getOddNumbers(Map<String,Object> model){
        List<Object[]> oddNumbers = streetRepos.findIdAndStreetName();
        model.put("oddNumbers", oddNumbers);
        return "result";
    }
}
