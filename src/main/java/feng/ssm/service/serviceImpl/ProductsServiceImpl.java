package feng.ssm.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import feng.ssm.dao.IProductsDao;
import feng.ssm.domain.Products;
import feng.ssm.service.IProductsService;

import java.util.List;

@Service
@Transactional
public class ProductsServiceImpl implements IProductsService {

    @Autowired
    private IProductsDao productsDao;

    @Override
    public List<Products> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return productsDao.findAll();
    }

    @Override
    public void save(Products products) throws Exception {
        productsDao.save(products);
    }

    @Override
    public Products findById(Integer id) throws Exception {
        return productsDao.findById(id);
    }

    @Override
    public List<Products> findByName(Integer page, Integer size,String name) throws Exception {
        PageHelper.startPage(page,size);
        return productsDao.findByName(name);
    }

    @Override
    public void delete(String id) throws Exception {
        productsDao.delete(id);
    }

    @Override
    public void delSelectedProduct(String[] ids) throws Exception {
        if(ids != null && ids.length > 0){
            //1.遍历数组
            for (String id : ids) {
                //2.调用dao删除
                productsDao.delete(id);
            }
        }
    }

    @Override
    public void update(Products products) throws Exception {
        productsDao.update(products);
    }


}
