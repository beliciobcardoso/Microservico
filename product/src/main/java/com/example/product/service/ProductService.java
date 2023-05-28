package com.example.product.service;

import com.example.product.model.DTO.ProductDTO;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<ProductDTO> findAllDTO() {
        List<Product> listProduct = productRepository.findAll();
        List<ProductDTO> listProductDTO = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Product p : listProduct){
            listProductDTO.add(mapper.convertValue(p, ProductDTO.class));
        }
        return listProductDTO;
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }


}
