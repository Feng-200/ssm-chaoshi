package feng.ssm.service;

import feng.ssm.domain.Products;

import java.util.List;

public interface IProductsService {
    List<Products> findAll(Integer page, Integer size) throws Exception;

    void save(Products products) throws Exception;

    Products findById(Integer productId) throws Exception;

    List<Products> findByName(Integer page, Integer size,String name) throws Exception;

    void delete(String id) throws Exception;

    void delSelectedProduct(String[] ids) throws Exception;

    void update(Products products) throws Exception;

}
