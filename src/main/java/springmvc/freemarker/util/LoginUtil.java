package springmvc.freemarker.util;

import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.Date;

/**
 * @author p-tvo-thuynd
 */
public class LoginUtil {
    public static boolean isLogin(HttpSession session) {
        return !(session == null || session.getAttribute("userInfo") == null);
    }

    /**
     * generate token based on userId and current date and time.
     *
     * @param userId id of current user.
     * @param date   time when user logs in
     * @return token.
     */
    public static String generateToken(String userId, Date date) {
        return new String(Base64.getEncoder().encode((userId + "|" + date.getTime()).getBytes()));
    }

    /**
     * check whether user logs in or not.
     *
     * @param session HttpSession object.
     * @return boolean value.
     */
    public static boolean checkAuthen(HttpSession session) {
        return session.getAttribute("userInfo") != null;
    }
}
