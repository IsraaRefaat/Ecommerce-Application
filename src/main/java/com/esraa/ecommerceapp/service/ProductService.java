package com.esraa.ecommerceapp.service;

import com.esraa.ecommerceapp.model.Product;
import com.esraa.ecommerceapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getAllProducts() {

        return productRepo.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepo.findById(productId).orElse(null);
    }

    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImage(image.getBytes());
        return productRepo.save(product);
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
         return productRepo.searchProducts(keyword);

    }


//    public void updateProduct(Long id, Product product , MultipartFile image) throws IOException {
//        for(Product p : getAllProducts()) {
//            if(p.getId() == id) {
//                p= product;
//                p.setImageName(image.getOriginalFilename());
//                p.setImageType(image.getContentType());
//                p.setImage(image.getBytes());
//                productRepo.save(p);
//            }
//        }
//
//    }
}
