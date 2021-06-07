package feng.ssm.dao;

import feng.ssm.domain.Bumen;
import feng.ssm.domain.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IBumenDao {
    /**
     * 根据id查询商品种类信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from bumen where id = #{id}")
    Bumen findById(Integer id) throws Exception;

    /**
     * 查询所有商品种类信息
     *
     * @return
     */
    @Select("select * from bumen")
    List<Bumen> findAll() throws Exception;

    /**
     * 查询所有商品种类信息
     *
     * @return
     */
    @Select("select * from bumen where bumenName like '%${bumenName}%'")
    List<Bumen> findByName(@Param("bumenName") String name) throws Exception;

    /**
     * 新增商品种类信息
     *
     * @param bumen
     * @throws Exception
     */
    @Insert("insert into bumen(id,bumenName,bumenDesc) values(#{id},#{bumenName},#{bumenDesc})")
    void save(Bumen bumen) throws Exception;

    /**
     * 删除商品种类
     *
     * @param id
     * @throws Exception
     */
    @Delete("delete from bumen where id = #{id}")
    void delete(Integer id) throws Exception;

    @Update("update bumen set id=#{id},bumenName=#{bumenName},bumenDesc=#{bumenDesc} where id=#{id}")
    void update(Bumen bumen) throws Exception;
}
