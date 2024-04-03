package com.example.demo.service;

import com.example.demo.domain.Part;
import com.example.demo.exceptions.InventoryConstraintViolationException;
import com.example.demo.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;

    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> findAll() {
        return (List<Part>) partRepository.findAll();
    }
    @Override
    public List<Part> listAll(String keyword) {
        if (keyword != null) {
            return partRepository.search(keyword);
        }
        return (List<Part>) partRepository.findAll();
    }

    @Override
    public Part findById(int theId) {
        Optional<Part> result = partRepository.findById((long) theId);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Did not find part id - " + theId);
        }
    }

    @Override
    public void save(Part thePart) {
        partRepository.save(thePart);
    }

    @Override
    public void deleteById(int theId) {
        partRepository.deleteById((long) theId);
    }

    public void updatePartInventory(int theId, int newInventory) throws InventoryConstraintViolationException {
        Part part = this.findById(theId);

        if (newInventory < part.getMinInv()) {
            throw new InventoryConstraintViolationException("Error: Low Inventory");
        } else if (newInventory > part.getMaxInv()) {
            throw new InventoryConstraintViolationException("Error: Inventory exceeded the maximum inventory");
        }

        part.setInv(newInventory);
        partRepository.save(part);
    }

}



