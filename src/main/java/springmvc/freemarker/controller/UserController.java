package springmvc.freemarker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.freemarker.form.UserForm;
import springmvc.freemarker.model.User;
import springmvc.freemarker.service.DepartmentService;
import springmvc.freemarker.service.PositionService;
import springmvc.freemarker.service.TitleService;
import springmvc.freemarker.service.UserService;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private TitleService titleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model){

        model.addAttribute("users", userService.getListUsers());
        return "user/userList";
    }

    EntityManager entityManager;

    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public String addNew(Model model){

        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        model.addAttribute("departments",departmentService.getListDepartments() );
        model.addAttribute("positions",positionService.getList());
        model.addAttribute("titles", titleService.getList());
        return "user/addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute UserForm userForm, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("departments",departmentService.getListDepartments() );
            model.addAttribute("positions",positionService.getList());
            model.addAttribute("titles", titleService.getList());
            return "user/addUser";
        }

        if(userService.validateUserName(userForm.getUserName())){
            result.rejectValue("userName", "userNameExist");
            model.addAttribute("departments",departmentService.getListDepartments() );
            model.addAttribute("positions",positionService.getList());
            model.addAttribute("titles", titleService.getList());
            return "user/addUser";
        }

        userService.addUser(userForm);

        List<User> users = userService.getListUsers();
        model.addAttribute("users", users);
        return "user/userList";
    }

//    @GetMapping("/showDetail/{userId}")
    @GetMapping("/showDetail")
    public String showDetail(@RequestParam(name = "userId") Integer userId, Model model){

        User user = userService.showDetail(userId);

        UserForm userForm = new UserForm();
        userForm.setName(user.getName());
        userForm.setUserId(user.getUserId());
        userForm.setPassword(user.getPassword());
        userForm.setUserName(user.getUserName());
        if(user.getDepartment() != null){
            userForm.setDepartmentId(user.getDepartment().getDepartmentId());
        }

        if(user.getTitle() != null && user.getTitle().getTitleId() != null) {
            userForm.setTitleId(user.getTitle().getTitleId());
        }

        if(user.getPosition() != null && user.getPosition().getPositionId() != null){
            userForm.setPositionId(user.getPosition().getPositionId());
        }

        model.addAttribute("userForm",userForm);
        model.addAttribute("departments",departmentService.getListDepartments() );
        model.addAttribute("positions",positionService.getList());
        model.addAttribute("titles", titleService.getList());

        return "user/addUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@Valid @ModelAttribute UserForm userForm, BindingResult result,
                             @RequestParam("userId")Integer userId, Model model){

        if(result.hasErrors()){
            model.addAttribute("departments",departmentService.getListDepartments() );
            model.addAttribute("positions",positionService.getList());
            model.addAttribute("titles", titleService.getList());
            return "user/addUser";
        }

        userService.updateUser(userForm, userId);

        return "redirect:/user/";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("userId") Integer userId){

        userService.deleteUser(userId);
        return "redirect:/user/";
    }
}
