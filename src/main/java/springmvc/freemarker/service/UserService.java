package springmvc.freemarker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import springmvc.freemarker.form.UserForm;
import springmvc.freemarker.model.User;


public interface UserService {

    List<User> getListUsers();
    boolean addUser(UserForm userForm);

    User showDetail(Integer userId);

    boolean updateUser(UserForm userForm, Integer userId);

    boolean deleteUser(Integer userId);

    boolean validateUserName(String userName);
}
