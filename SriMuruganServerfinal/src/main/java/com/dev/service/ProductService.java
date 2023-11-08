package com.dev.service;

import java.util.List;

import com.dev.entity.Product;

public interface ProductService {
	      public List<Product> getProducts();
          public Product addProduct(Product product);
          public Product deleteProduct(int id );
          public Product updateProduct(int id , Product product);
}
