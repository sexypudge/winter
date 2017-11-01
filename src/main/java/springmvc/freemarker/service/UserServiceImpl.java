package springmvc.freemarker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.freemarker.dao.UserDao;
import springmvc.freemarker.form.UserForm;
import springmvc.freemarker.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getListUsers() {
        return userDao.getListUsers();
    }

    @Override
    public boolean addUser(UserForm userForm) {
        return userDao.addUser(userForm);
    }

    @Override
    public User showDetail(Integer userId) {
        return userDao.showDetail(userId);
    }

    @Override
    public boolean updateUser(UserForm userForm, Integer userId) {
        return userDao.updateUser(userForm,userId);
    }

    @Override
    public boolean deleteUser(Integer userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public boolean validateUserName(String userName) {
        return userDao.validateUserName(userName);
    }
}
