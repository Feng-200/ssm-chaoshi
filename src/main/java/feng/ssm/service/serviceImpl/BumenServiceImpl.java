package feng.ssm.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import feng.ssm.dao.IBumenDao;
import feng.ssm.dao.ICategoryDao;
import feng.ssm.domain.Bumen;
import feng.ssm.domain.Category;
import feng.ssm.service.IBumenService;
import feng.ssm.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BumenServiceImpl implements IBumenService {

    @Autowired
    private IBumenDao bumenDao;

    @Override
    public List<Bumen> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return bumenDao.findAll();
    }

    @Override
    public List<Bumen> findByName(int page, int size, String name) throws Exception {
        PageHelper.startPage(page,size);
        return bumenDao.findByName(name);
    }

    @Override
    public void save(Bumen bumen) throws Exception {

        bumenDao.save(bumen);
    }

    @Override
    public List<Bumen> findBumen() throws Exception {
        List<Bumen> list = bumenDao.findAll();
        return list;
    }

    @Override
    public void delete(Integer id) throws Exception {
        bumenDao.delete(id);
    }

    @Override
    public Bumen findById(Integer id) throws Exception {
        return bumenDao.findById(id);
    }

    @Override
    public void update(Bumen bumen) throws Exception {
        bumenDao.update(bumen);
    }
}
