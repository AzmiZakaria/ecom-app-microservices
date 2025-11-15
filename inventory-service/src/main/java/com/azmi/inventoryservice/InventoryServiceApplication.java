package com.azmi.inventoryservice;

import com.azmi.inventoryservice.entities.Product;
import com.azmi.inventoryservice.repositoriy.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Computer")
                    .price(6000)
                    .quantity(20)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Phone")
                    .price(3000)
                    .quantity(50)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Printer")
                    .price(1500)
                    .quantity(10)
                    .build());
            productRepository.findAll().forEach(p->System.out.println(p.toString()));
        };
    }
}
