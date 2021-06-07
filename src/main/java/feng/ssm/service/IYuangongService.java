package feng.ssm.service;

import feng.ssm.domain.Products;
import feng.ssm.domain.Yuangong;

import java.util.List;

public interface IYuangongService {
    List<Yuangong> findAll(Integer page, Integer size) throws Exception;

    void save(Yuangong yuangong) throws Exception;

    Yuangong findById(Integer id) throws Exception;

    List<Yuangong> findByName(Integer page, Integer size,String name) throws Exception;

    void delete(String id) throws Exception;

    void delSelectedYuangong(String[] ids) throws Exception;

    void update(Yuangong yuangong) throws Exception;

}
