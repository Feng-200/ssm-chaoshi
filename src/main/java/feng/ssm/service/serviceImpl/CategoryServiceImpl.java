package feng.ssm.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import feng.ssm.dao.ICategoryDao;
import feng.ssm.domain.Category;
import feng.ssm.service.ICategoryService;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public List<Category> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return categoryDao.findAll();
    }

    @Override
    public List<Category> findByName(int page, int size, String name) throws Exception {
        PageHelper.startPage(page,size);
        return categoryDao.findByName(name);
    }

    @Override
    public void save(Category category) throws Exception {
        categoryDao.save(category);
    }

    @Override
    public List<Category> findCategory() throws Exception {
        List<Category> list = categoryDao.findAll();
        return list;
    }

    @Override
    public void delete(Integer id) throws Exception {
        categoryDao.delete(id);
    }

    @Override
    public Category findById(Integer id) throws Exception {
        return categoryDao.findById(id);
    }

    @Override
    public void update(Category category) throws Exception {
        categoryDao.update(category);
    }
}
