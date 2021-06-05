package feng.ssm.dao;

import org.apache.ibatis.annotations.*;
import feng.ssm.domain.Category;

import java.util.List;

public interface ICategoryDao {
    /**
     * 根据id查询商品种类信息
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from category where id = #{id}")
    Category findById(Integer id) throws Exception;

    /**
     * 查询所有商品种类信息
     * @return
     */
    @Select("select * from category")
    List<Category> findAll() throws Exception;
    /**
     * 查询所有商品种类信息
     * @return
     */
    @Select("select * from category where catName like '%${catName}%'")
    List<Category> findByName(@Param("catName") String name) throws Exception;

    /**
     * 新增商品种类信息
     * @param category
     * @throws Exception
     */
    @Insert("insert into category(id,catName,catDesc) values(#{id},#{catName},#{catDesc})")
    void save(Category category) throws Exception;

    /**
     * 删除商品种类
     * @param id
     * @throws Exception
     */
    @Delete("delete from category where id = #{id}")
    void delete(Integer id) throws Exception;

    @Update("update category set id=#{id},catName=#{catName},catDesc=#{catDesc} where id=#{id}")
    void update(Category category) throws Exception;
}
