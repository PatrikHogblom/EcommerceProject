package com.ecommerceProject.ecom.services.admin.product;

import com.ecommerceProject.ecom.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface IAdminProductService {
    ProductDto addProduct(ProductDto productDto) throws IOException;
    List<ProductDto> getAllProducts();
    List<ProductDto> getAllProductsByName(String name);
}
