package springmvc.freemarker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.freemarker.form.DepartmentForm;
import springmvc.freemarker.form.UserForm;
import springmvc.freemarker.model.Department;
import springmvc.freemarker.model.User;
import springmvc.freemarker.service.DepartmentService;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("departments", departmentService.getListDepartments());
        return "department/departmentList";
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public String addNew(Model model){
        DepartmentForm departmentForm = new DepartmentForm();
        model.addAttribute("departmentForm", departmentForm);
        return "department/addDepartment";
    }

    @PostMapping("/add")
    public String addDepartment(@Valid @ModelAttribute DepartmentForm departmentForm, BindingResult result, Model model){

        if(result.hasErrors()){
            return "department/addDepartment";
        }

        if(departmentService.validateDepartmentName(departmentForm.getDepartmentName())){
            result.rejectValue("departmentName", "departmentNameExist");
            return "department/addDepartment";
        }

        departmentService.addDepartment(departmentForm);

        return "redirect:/department/";
    }

    @GetMapping("/showDetail")
    public String showDetail(@RequestParam(name = "departmentId") Integer departmentId, Model model){

        Department department = departmentService.showDetail(departmentId);

        DepartmentForm departmentForm = new DepartmentForm();
        departmentForm.setDepartmentId(department.getDepartmentId());
        departmentForm.setDepartmentName(department.getDepartmentName());


        model.addAttribute("departmentForm",departmentForm);
        return "department/addDepartment";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute DepartmentForm departmentForm, BindingResult result,
                             @RequestParam("departmentId")Integer departmentId, Model model){

        if(result.hasErrors()){
            return "department/addDepartment";
        }

        departmentService.updateDepartment(departmentForm, departmentId);

        return "redirect:/department/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("departmentId") Integer departmentId){

        departmentService.deleteDepartment(departmentId);
        return "department/departmentList";
    }
}
