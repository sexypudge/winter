package springmvc.freemarker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.freemarker.dao.LoginDao;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    public void setLoginDAO(LoginDao loginDAO) {
        this.loginDao = loginDAO;
    }

    public boolean checkLogin(String userName, String userPassword){
        System.out.println("In Service class...Check Login");
        return loginDao.checkLogin(userName, userPassword);
    }
}
