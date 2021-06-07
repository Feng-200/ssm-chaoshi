package feng.ssm.dao;

import feng.ssm.domain.Bumen;
import feng.ssm.domain.Category;
import feng.ssm.domain.Yuangong;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IYuangongDao {
    /**
     * 查询所有商品方法
     * @return
     */
    @Select("select * from yuangong")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "gongzi", column = "gongzi"),
            @Result(property = "bumen",column = "bumenId",javaType = Bumen.class,
                    one = @One(select = "feng.ssm.dao.IBumenDao.findById"))
    })
    List<Yuangong> findAll() throws Exception;

    /**
     * 增加商品信息
     * @param yuangong
     * @throws Exception
     */
    @Insert("insert into yuangong (id,name,phone,bumenId,gongzi) " +
            "values(#{id},#{name},#{phone},#{bumenId},#{gongzi})")
    void save(Yuangong yuangong) throws Exception;

    /**
     * 根据id查询商品
     * @param id
     * @return
     * @throws Exception
     */
    @Select({"select * from yuangong where id = #{id}"})
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "gongzi", column = "gongzi"),
            @Result(property = "bumen",column = "bumenId",javaType = Bumen.class,
                    one = @One(select = "feng.ssm.dao.IBumenDao.findById"))
    })
    Yuangong findById(Integer id) throws Exception;

    /**
     * 根据id查询商品
     * @param name
     * @return
     * @throws Exception
     */
    @Select({"select * from yuangong where name like '%${name}%'"})
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "gongzi", column = "gongzi"),
            @Result(property = "bumen",column = "bumenId",javaType = Bumen.class,
                    one = @One(select = "feng.ssm.dao.IBumenDao.findById"))
    })
    List<Yuangong> findByName(@Param("name") String name) throws Exception;

    /**
     * 删除商品
     * @param id
     * @throws Exception
     */
    @Delete("delete from yuangong where id = #{id}")
    void delete(String id) throws Exception;

    /**
     * 修改商品
     * @param yuangong
     * @throws Exception
     */
    @Update("update yuangong set id=#{id},name=#{name},phone=#{phone},gongzi=#{gongzi} where id=#{id}")
    void update(Yuangong yuangong) throws Exception;
}
