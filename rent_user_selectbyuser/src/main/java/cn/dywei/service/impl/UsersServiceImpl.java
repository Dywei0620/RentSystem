package cn.dywei.service.impl;

import cn.dywei.dao.UsersDao;
import cn.dywei.pojo.Users;
import cn.dywei.service.UsersService;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;
    @Override
    public Users selectByUsername(String username) {
        return usersDao.selectByUsername(username);
    }

    @Override
    @TccTransaction
    public int insert(Users user) {
        Users result = usersDao.insert(user);
        if(result!=null){
            return 1;
        }
        return 0;
    }

    /**
     * 把新增的数据进行删除
     * @param user
     */
    public void cancelInsert(Users user){
        System.out.println("cancel---------------");
        usersDao.deleteByUsername(user.getUsername());
    }
}
