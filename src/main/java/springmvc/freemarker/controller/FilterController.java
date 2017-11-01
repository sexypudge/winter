package springmvc.freemarker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.freemarker.form.FilterForm;
import springmvc.freemarker.model.User;
import springmvc.freemarker.service.DepartmentService;
import springmvc.freemarker.service.FilterService;
import springmvc.freemarker.service.PositionService;
import springmvc.freemarker.service.TitleService;
import springmvc.freemarker.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filter")
public class FilterController {

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private TitleService titleService;

    @Autowired
    private FilterService filterService;

    @GetMapping("/")
    public String filter(Model model){

        FilterForm filterForm = new FilterForm();
        model.addAttribute("filterForm", filterForm);
        model.addAttribute("users", userService.getListUsers());
        model.addAttribute("departments",departmentService.getListDepartments() );
        model.addAttribute("positions",positionService.getList());
        model.addAttribute("titles", titleService.getList());
        return "filter/filter";
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@ModelAttribute FilterForm filterForm, Model model){

        int de = filterForm.getDe();
        int ti = filterForm.getTi();
        int po = filterForm.getPo();

        model.addAttribute("users", filterService.search(filterForm.getDe(), filterForm.getTi(), filterForm.getPo()));
        model.addAttribute("departments",departmentService.getListDepartments() );
        model.addAttribute("positions",positionService.getList());
        model.addAttribute("titles", titleService.getList());

        filterForm = new FilterForm();
        filterForm.setDe(de);
        filterForm.setTi(ti);
        filterForm.setPo(po);

        model.addAttribute("filterForm", filterForm);
        return "filter/filter";
    }

}
