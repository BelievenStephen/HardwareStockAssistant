package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenControllerr {
    // private final PartRepository partRepository;
    // private final ProductRepository productRepository;'

    private PartService partService;
    private final ProductService productService;

    private List<Part> theParts;
    private List<Product> theProducts;

    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }

 /*   public MainScreenControllerr(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
    }*/

    @Autowired
    public MainScreenControllerr(PartService partService, ProductService productService) {
        this.partService = partService;
        this.productService = productService;
    }

    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword) {
        //add to the sprig model
        List<Part> partList = partService.listAll(partkeyword);
        theModel.addAttribute("parts", partList);
        theModel.addAttribute("partkeyword", partkeyword);
        //    theModel.addAttribute("products",productService.findAll());
        List<Product> productList = productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword", productkeyword);
        return "mainscreen";
    }

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productId") int productId, RedirectAttributes redirectAttributes) {

        Product product = productService.findById(productId);

        if (product != null && product.getInv() > 0) {
            product.setInv(product.getInv() - 1);
            productService.save(product);
            redirectAttributes.addFlashAttribute("success", "Product purchased successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Product could not be purchased. It may be out of stock.");
        }

        return "redirect:/mainscreen";
    }

}