package com.example.demo.service;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.exceptions.InventoryConstraintViolationException;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    @Autowired
    private PartService partService;

    @Autowired

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(int theId) {
        Long theIdl=(long)theId;
        Optional<Product> result = productRepository.findById(theIdl);

        Product theProduct = null;

        if (result.isPresent()) {
            theProduct = result.get();
        }
        else {
            // we didn't find the product id
            throw new RuntimeException("Did not find part id - " + theId);
        }

        return theProduct;
    }

    @Override
    public void save(Product theProduct) {
        productRepository.save(theProduct);

    }

    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        productRepository.deleteById(theIdl);
    }
    public List<Product> listAll(String keyword){
        if(keyword !=null){
            return productRepository.search(keyword);
        }
        return (List<Product>) productRepository.findAll();
    }
    public void updateProductInventory(Long productId, int newInventory) throws InventoryConstraintViolationException {
        Product product = findById(productId.intValue());
        int inventoryDifference = newInventory - product.getInv();

        if (inventoryDifference > 0) {
            for (Part part : product.getParts()) {
                if (part.getInv() < inventoryDifference) {
                    throw new InventoryConstraintViolationException("Insufficient inventory for part: " + part.getName());
                }
                partService.updatePartInventory((int)part.getId(), part.getInv() - inventoryDifference);
            }
        }

        product.setInv(newInventory);
        productRepository.save(product);
    }
}
