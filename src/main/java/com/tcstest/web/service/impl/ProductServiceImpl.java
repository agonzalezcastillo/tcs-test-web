package com.tcstest.web.service.impl;

import com.tcstest.web.client.ProductClient;
import com.tcstest.web.exception.GeneralException;
import com.tcstest.web.model.Product;
import com.tcstest.web.service.ProductService;
import feign.RetryableException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductClient productClient;

    @Override
    public List<Product> getAllProducts() throws GeneralException {
        log.info("ProductsService - getAllProducts");
        try {
            return productClient.getProducts().getBody();
        }catch(RetryableException e){
            throw new GeneralException("Ha ocurrido un error inesperado");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new GeneralException("Ha ocurrido un error inesperado");
        }
    }

    @Override
    public Integer createProduct(Product product) throws GeneralException {
        try {
            return productClient.createProduct(product).getBody();
        }catch(RetryableException e){
            throw new GeneralException("Ha ocurrido un error inesperado");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new GeneralException("Ha ocurrido un error inesperado");
        }
    }

    @Override
    public Product getProductById(Integer id) throws GeneralException {
        try {
            return productClient.getProduct(id).getBody();
        }catch(RetryableException e){
            throw new GeneralException("Ha ocurrido un error inesperado");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new GeneralException("Ha ocurrido un error inesperado");
        }
    }

    @Override
    public Integer updateProduct(Product product) throws GeneralException {
        try {
            return productClient.updateProduct(product).getBody();
        }catch(RetryableException e){
            throw new GeneralException("Ha ocurrido un error inesperado");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new GeneralException("Ha ocurrido un error inesperado");
        }
    }
}
