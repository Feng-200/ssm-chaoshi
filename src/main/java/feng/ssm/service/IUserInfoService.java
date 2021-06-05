package feng.ssm.service;

import feng.ssm.domain.UserInfo;


public interface IUserInfoService {


    void save(UserInfo adminUsers) throws Exception;

    UserInfo findByName(String username) throws Exception;

    void updatePassWord(UserInfo adminUsers) throws Exception;

    void update(UserInfo adminUsers) throws Exception;
}

