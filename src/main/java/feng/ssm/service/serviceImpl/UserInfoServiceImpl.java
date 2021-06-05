package feng.ssm.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import feng.ssm.dao.IUserInfoDao;
import feng.ssm.domain.UserInfo;
import feng.ssm.service.IUserInfoService;


@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoDao userInfoDao;


    @Override
    public void save(UserInfo userInfo) throws Exception {
        userInfoDao.save(userInfo);
    }

    @Override
    public UserInfo findByName(String username) throws Exception {
        return userInfoDao.findByUsername(username);
    }

    @Override
    public void updatePassWord(UserInfo userInfo) throws Exception {
        userInfoDao.updatePassWord(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) throws Exception {
        userInfoDao.update(userInfo);
    }


}
