package com.dev.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dev.entity.Product;
import com.dev.service.ProductService;
import com.dev.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @Autowired
    private SequenceGeneratorService seqGen;
    
    @GetMapping("/all")
    public List<Product> getProducts() {
       return productService.getProducts();
    }

//    @PostMapping("/insert")
//    public Product insert(@RequestBody Product product){
//        return  productService.addProduct(product);
//    }
    @PostMapping("/insert")
    public Product insert(@ModelAttribute Product product, @RequestParam("imageFile") MultipartFile imageFile) {
        if (imageFile != null) {
            try {
                byte[] imageBytes = imageFile.getBytes();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                product.setImageBase64(base64Image);
            } catch (IOException e) {
            	return product;
                // Handle exception
            }
        }
        // GeneterateSequenece
        product.setId(seqGen.getSequenceNumber(Product.SEQUENCE_NAME));
        return productService.addProduct(product);
    }

    @PutMapping("/update/{id}")
   public Product update(@PathVariable int id,@RequestBody Product product ){
       return productService.updateProduct(id,product);
    }

    @DeleteMapping("/delete/{id}")
    public Product delete(@PathVariable int id ){

        return  productService.deleteProduct(id);
    }
}