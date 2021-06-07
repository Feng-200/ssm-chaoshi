package feng.ssm.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import feng.ssm.dao.IProductsDao;
import feng.ssm.dao.IYuangongDao;
import feng.ssm.domain.Products;
import feng.ssm.domain.Yuangong;
import feng.ssm.service.IProductsService;
import feng.ssm.service.IYuangongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class YuangongServiceImpl implements IYuangongService {

    @Autowired
    private IYuangongDao yuangongDao;

    @Override
    public List<Yuangong> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return yuangongDao.findAll();
    }

    @Override
    public void save(Yuangong yuangong) throws Exception {
        yuangongDao.save(yuangong);
    }

    @Override
    public Yuangong findById(Integer id) throws Exception {
        return yuangongDao.findById(id);
    }

    @Override
    public List<Yuangong> findByName(Integer page, Integer size, String name) throws Exception {
        PageHelper.startPage(page,size);
        return yuangongDao.findByName(name);
    }

    @Override
    public void delete(String id) throws Exception {
        yuangongDao.delete(id);
    }

    @Override
    public void delSelectedYuangong(String[] ids) throws Exception {
        if(ids != null && ids.length > 0){
            //1.遍历数组
            for (String id : ids) {
                //2.调用dao删除
                yuangongDao.delete(id);
            }
        }
    }

    @Override
    public void update(Yuangong yuangong) throws Exception {
        yuangongDao.update(yuangong);
    }
}
