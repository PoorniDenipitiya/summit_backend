package com.foodie.psb_product.service;

import com.foodie.psb_product.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(String id);
    ProductDTO updateProduct(String id, ProductDTO productDTO);
    void deleteProduct(String id);
}