package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.exceptions.InventoryConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
/**
 *
 *
 *
 *
 */
@Controller
public class AddOutsourcedPartController {

    @Autowired
    private OutsourcedPartService outsourcedPartService; // Directly autowire the service

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(Model theModel) {
        OutsourcedPart part = new OutsourcedPart();
        theModel.addAttribute("outsourcedpart", part);
        return "OutsourcedPartForm";
    }

    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") OutsourcedPart part, BindingResult bindingResult, Model theModel) {
        theModel.addAttribute("outsourcedpart", part);

        if (!part.isInventoryValid()) {
            bindingResult.rejectValue("inv", "error.outsourcedpart", "Inventory must be between the specified min and max values.");
        }

        if (bindingResult.hasErrors()) {
            return "OutsourcedPartForm";
        } else {
            outsourcedPartService.save(part);
            return "confirmationaddpart";
        }
    }

    @ExceptionHandler(InventoryConstraintViolationException.class)
    public String handleInventoryConstraintViolation(InventoryConstraintViolationException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "parts/error";
    }
}
