package feng.ssm.service;

import feng.ssm.domain.Bumen;
import feng.ssm.domain.Category;

import java.util.List;

public interface IBumenService {
    /**
     * 查询所有部门信息
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<Bumen> findAll(int page, int size) throws Exception;

    List<Bumen> findByName(int page, int size,String name) throws Exception;

    /**
     * 新增部门信息
     * @param bumen
     */
    void save(Bumen bumen) throws Exception;

    /**
     * 部门信息回显
     * @return
     * @throws Exception
     */
    List<Bumen> findBumen() throws Exception;

    void delete(Integer id) throws Exception;

    Bumen findById(Integer id) throws Exception;

    void update(Bumen bumen) throws Exception;
}
