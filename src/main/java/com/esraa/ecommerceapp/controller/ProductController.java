package com.esraa.ecommerceapp.controller;

import com.esraa.ecommerceapp.model.Product;
import com.esraa.ecommerceapp.service.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("product/{productId}")
    public Product getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }

    @PostMapping("product")
    public ResponseEntity<?> addProduct(@RequestPart Product product , @RequestPart MultipartFile image){
        Product savedProduct = null;
        try {
             savedProduct = productService.addOrUpdateProduct(product , image);
             return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);

        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("product/{productId}/image")
//    public ResponseEntity<byte []> getProductImage(@PathVariable Long productId){
//
//        Product product = productService.getProductById(productId);
//        if(product == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(product.getImage(), HttpStatus.OK);
//
//    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);
        if (product.getId() > 0) {
            return new ResponseEntity<>(product.getImage(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestPart Product product, @RequestPart MultipartFile image){

        try {
            productService.addOrUpdateProduct(product , image);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){

        Product deletedProduct = productService.getProductById(id);

        if (deletedProduct != null) {
            productService.delete(id);
            return new ResponseEntity<>(deletedProduct, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
        List<Product> searchedProducts = productService.searchProducts(keyword);

        return new ResponseEntity<>(searchedProducts, HttpStatus.OK);
    }

}
