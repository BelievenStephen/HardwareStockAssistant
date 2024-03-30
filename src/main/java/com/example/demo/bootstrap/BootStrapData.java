package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        if (partRepository.count() == 0 && productRepository.count() == 0) {
            // First Part
            OutsourcedPart part1 = new OutsourcedPart();
            part1.setCompanyName("AutoParts Central");
            part1.setName("High-Performance Brake Pads");
            part1.setInv(60);
            part1.setPrice(150.00);
            outsourcedPartRepository.save(part1);

            // Additional Parts
            createAndSaveOutsourcedPart("Synthetic Motor Oil", 75, 45.99, "AutoParts Central");
            createAndSaveOutsourcedPart("High Performance Air Intake System", 30, 319.99, "AutoParts Central");
            createAndSaveOutsourcedPart("High-Performance Battery", 45, 199.99, "AutoParts Central");
            createAndSaveOutsourcedPart("Adjustable Coilover Suspension Kit", 20, 899.99, "AutoParts Central");

            // First Product
            Product product1 = new Product("Turbocharger Kit", 1499.99, 10);
            productRepository.save(product1);

            // Additional Products
            createAndSaveProduct("Professional Detailing Kit", 159.99, 20);
            createAndSaveProduct("ECU Tuning Module", 499.99, 25);
            createAndSaveProduct("Full Synthetic Oil Change Kit", 84.99, 50);
            createAndSaveProduct("Performance Clutch Kit", 749.99, 15);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: " + productRepository.count());
        System.out.println("Number of Parts: " + partRepository.count());
    }

    private void createAndSaveOutsourcedPart(String name, int inventory, double price, String companyName) {
        OutsourcedPart part = new OutsourcedPart();
        part.setName(name);
        part.setInv(inventory);
        part.setPrice(price);
        part.setCompanyName(companyName);
        outsourcedPartRepository.save(part);
    }

    private void createAndSaveProduct(String name, double price, int inventory) {
        Product product = new Product(name, price, inventory);
        productRepository.save(product);
    }
}