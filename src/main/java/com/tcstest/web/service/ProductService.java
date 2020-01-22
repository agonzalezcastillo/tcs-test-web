package com.tcstest.web.service;

import com.tcstest.web.exception.GeneralException;
import com.tcstest.web.model.Product;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws GeneralException;
    Integer createProduct(Product product) throws GeneralException;
    Product getProductById(Integer id) throws GeneralException;
    Integer updateProduct(Product product) throws GeneralException;
}
