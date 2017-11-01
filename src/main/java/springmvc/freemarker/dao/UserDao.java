package springmvc.freemarker.dao;

import java.util.List;

import springmvc.freemarker.form.UserForm;
import springmvc.freemarker.model.User;

public interface UserDao {
    List<User> getListUsers();

    boolean addUser(UserForm userForm);

    User showDetail(Integer userId);

    boolean updateUser(UserForm userForm, Integer userId);

    boolean deleteUser(Integer userId);

    boolean validateUserName(String userName);

}
