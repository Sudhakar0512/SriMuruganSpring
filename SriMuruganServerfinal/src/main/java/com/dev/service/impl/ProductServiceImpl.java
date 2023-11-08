package com.dev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dev.entity.Product;
import com.dev.repo.ProductRepo;
import com.dev.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> getProducts() {
//        return productRepo.findAll();
    	return productRepo.findAll(Sort.by(Sort.Order.desc("id")));
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product deleteProduct(int id) {
        Product product = productRepo.findById(id).get();
        productRepo.delete(product);
        return product;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product productVar = productRepo.findById(id).get();
        productVar.setName(product.getName());
//        productVar.setPrice(product.getPrice());
//      productVar.setQuantity(product.getQuantity());
      productRepo.save(productVar);
      return productVar;


    }
}
