package feng.ssm.dao;

import org.apache.ibatis.annotations.*;
import feng.ssm.domain.Category;
import feng.ssm.domain.Products;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductsDao {
    /**
     * 查询所有商品方法
     * @return
     */
    @Select("select * from products")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "price", column = "price"),
            @Result(property = "productDesc", column = "productDesc"),
            @Result(property = "category",column = "categoryId",javaType = Category.class,
                    one = @One(select = "feng.ssm.dao.ICategoryDao.findById"))
    })
    List<Products> findAll() throws Exception;

    /**
     * 增加商品信息
     * @param products
     * @throws Exception
     */
    @Insert("insert into products (id,name,price,categoryId,productDesc) " +
            "values(#{id},#{name},#{price},#{categoryId},#{productDesc})")
    void save(Products products) throws Exception;

    /**
     * 根据id查询商品
     * @param id
     * @return
     * @throws Exception
     */
    @Select({"select * from products where id = #{id}"})
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "price", column = "price"),
            @Result(property = "productDesc", column = "productDesc"),
            @Result(property = "category",column = "categoryId",javaType = Category.class,
                    one = @One(select = "feng.ssm.dao.ICategoryDao.findById"))
    })
    Products findById(Integer id) throws Exception;

    /**
     * 根据name查询商品
     * @param name
     * @return
     * @throws Exception
     */
    @Select({"select * from products where name like '%${name}%'"})
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "price", column = "price"),
            @Result(property = "productDesc", column = "productDesc"),
            @Result(property = "category",column = "categoryId",javaType = Category.class,one = @One(select = "feng.ssm.dao.ICategoryDao.findById"))
    })
    List<Products> findByName(@Param("name") String name) throws Exception;

    /**
     * 删除商品
     * @param id
     * @throws Exception
     */
    @Delete("delete from products where id = #{id}")
    void delete(String id) throws Exception;

    /**
     * 修改商品
     * @param products
     * @throws Exception
     */
    @Update("update products set id=#{id},name=#{name},price=#{price},productDesc=#{productDesc} where id=#{id}")
    void update(Products products) throws Exception;
}
