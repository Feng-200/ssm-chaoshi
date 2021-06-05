package feng.ssm.dao;

import org.apache.ibatis.annotations.*;
import feng.ssm.domain.UserInfo;
import java.util.List;


public interface IUserInfoDao {
    /**
     * 根据用户名查询所有信息   登录功能用到
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    })
    UserInfo findByUsername(String username) throws Exception;

    /**
     * 查询所有管理员信息
     * @return
     * @throws Exception
     */
    @Select("select * from adminusers")
    @Results({
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    })
    List<UserInfo> findAll() throws Exception;

    /**
     * 注册管理员数据
     * @param userInfo
     * @throws Exception
     */
    @Insert("insert into users(username,password,peopleName,phoneNum) values(#{username},#{password},#{peopleName},#{phoneNum})")
    void save(UserInfo userInfo) throws Exception;

    /**
     * 修改密码
     * @param userInfo
     * @throws Exception
     */
    @Update("update users set username=#{username},password=#{password} where username = #{username}")
    void updatePassWord(UserInfo userInfo) throws Exception;

    @Delete("delete from users where id = #{id}")
    void delete(Integer id) throws Exception;

    @Select("select * from users where id = #{id}")
    UserInfo findById(Integer id);

    @Update("update users set username=#{username},email=#{email},phoneNum=#{phoneNum} where id=#{id}")
    void update(UserInfo userInfo);
}
