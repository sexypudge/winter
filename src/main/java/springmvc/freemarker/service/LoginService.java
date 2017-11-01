package springmvc.freemarker.service;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface LoginService {
    boolean checkLogin(String userId, String password);
}
