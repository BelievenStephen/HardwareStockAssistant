package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Product>, ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        EnufPartsValidator.applicationContext = applicationContext;
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if (applicationContext == null) {
            return true;
        }

        ProductService repo = applicationContext.getBean(ProductService.class);
        boolean valid = true;

        if (product.getId() != 0) {
            Product existingProduct = repo.findById((int) product.getId());

            for (Part p : existingProduct.getParts()) {
                int projectedInventoryAfterProductUpdate = p.getInv() - (product.getInv() - existingProduct.getInv());
                if (projectedInventoryAfterProductUpdate < p.getMinInv()) {
                    valid = false;
                    constraintValidatorContext.disableDefaultConstraintViolation();
                    constraintValidatorContext.buildConstraintViolationWithTemplate("Updating product " + product.getName() + " would lower the inventory of part " + p.getName() + " below its minimum level.")
                            .addConstraintViolation();
                }
            }
        }
        return valid;
    }
}
