package springmvc.freemarker.form;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    /**
     * @return the userId
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserName(String userId) {
        this.userName = userId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
