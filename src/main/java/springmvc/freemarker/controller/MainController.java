package springmvc.freemarker.controller;

import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springmvc.freemarker.form.LoginForm;
import springmvc.freemarker.model.User;
import springmvc.freemarker.service.LoginService;
import springmvc.freemarker.service.UserService;
import springmvc.freemarker.util.LoginUtil;
import org.springframework.validation.BindingResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@Scope("session")
public class MainController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        User user = (User) request.getUserPrincipal();

        if(request.getSession().getAttribute("loggedIn") == null || !(Boolean) request.getSession().getAttribute("loggedIn") ){
            LoginForm loginForm = new LoginForm();
            model.addAttribute("loginForm", loginForm);
            return "login/login";
        }

        return "common/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String performLogin(@Valid @ModelAttribute LoginForm loginForm, BindingResult bindingResult, Model model,
                               HttpServletRequest request) {
        if(bindingResult.hasErrors()){
            return "login/login";
        }

        boolean userExists = loginService.checkLogin(loginForm.getUserName(),
            loginForm.getPassword());

        if(!userExists){
            bindingResult.rejectValue("userName","invalidUser");
            return "login/login";
        }
        request.getSession().setAttribute("loggedIn", userExists);

        return "redirect:/";

    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String performLogout(HttpServletRequest request, Model model){

        request.getSession().setAttribute("loggedIn", null);

        try {
            request.logout();
        } catch (ServletException e) {
            System.out.println(e.toString());
        }

        return "redirect:/";
    }

}
