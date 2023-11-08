package com.dev.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dev.entity.Product;

public interface ProductRepo extends MongoRepository<Product, Integer> {
   
}
