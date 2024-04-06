package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
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
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }


        if (partRepository.count() == 0 && productRepository.count() == 0) {
            // Create and save sample Parts
            InhousePart cpu = new InhousePart("CPU", 250.00, 10, 2, 20, 123);
            partRepository.save(cpu);
            InhousePart gpu = new InhousePart("GPU", 400.00, 5, 1, 10, 124);
            partRepository.save(gpu);
            InhousePart ram = new InhousePart("RAM", 150.00, 20, 2, 40, 125);
            partRepository.save(ram);
            InhousePart hardDrive = new InhousePart("Hard Drive", 100.00, 15, 2, 30, 126);
            partRepository.save(hardDrive);
            InhousePart powerSupply = new InhousePart("Power Supply", 90.00, 10, 1, 20, 127);
            partRepository.save(powerSupply);

//            // Create and save sample Products
            Product gamingPC = new Product("Gaming PC", 1200.00, 5);
//            gamingPC.getParts().add(cpu);
//            gamingPC.getParts().add(gpu);
//            gamingPC.getParts().add(ram);
            productRepository.save(gamingPC);

            Product workstation = new Product("Workstation PC", 1500.00, 5);
//            workstation.getParts().add(cpu);
//            workstation.getParts().add(gpu);
//            workstation.getParts().add(ram);
//            workstation.getParts().add(hardDrive);
            productRepository.save(workstation);

            Product homeOfficePC = new Product("Home Office PC", 800.00, 5);
//            homeOfficePC.getParts().add(cpu);
//            homeOfficePC.getParts().add(ram);
            productRepository.save(homeOfficePC);

            Product mediaCenter = new Product("Media Center", 700.00, 5);
//            mediaCenter.getParts().add(cpu);
//            mediaCenter.getParts().add(ram);
//            mediaCenter.getParts().add(hardDrive);
            productRepository.save(mediaCenter);
//
            Product laptop = new Product("Laptop", 1000.00, 5);
//            laptop.getParts().add(cpu);
//            laptop.getParts().add(ram);
            productRepository.save(laptop);
//
            System.out.println("Sample inventory added for Tech Central");
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}