package feng.ssm.service;

import feng.ssm.domain.UserInfo;


public interface IUserInfoService {


    void save(UserInfo userInfo) throws Exception;

    UserInfo findByName(String username) throws Exception;

    void updatePassWord(UserInfo userInfo) throws Exception;

    void update(UserInfo userInfo) throws Exception;
}

