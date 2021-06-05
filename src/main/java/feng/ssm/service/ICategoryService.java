package feng.ssm.service;

import feng.ssm.domain.Category;

import java.util.List;

public interface ICategoryService {
    /**
     * 查询所有部门信息
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<Category> findAll(int page, int size) throws Exception;

    List<Category> findByName(int page, int size,String name) throws Exception;

    /**
     * 新增部门信息
     * @param category
     */
    void save(Category category) throws Exception;

    /**
     * 部门信息回显
     * @return
     * @throws Exception
     */
    List<Category> findCategory() throws Exception;

    void delete(Integer id) throws Exception;

    Category findById(Integer id) throws Exception;

    void update(Category category) throws Exception;
}
