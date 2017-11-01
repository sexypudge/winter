package springmvc.freemarker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.freemarker.form.DepartmentForm;
import springmvc.freemarker.form.TitleForm;
import springmvc.freemarker.model.Department;
import springmvc.freemarker.model.Title;
import springmvc.freemarker.service.DepartmentService;
import springmvc.freemarker.service.TitleService;

import javax.validation.Valid;

@Controller
@RequestMapping("/title")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("titles", titleService.getList());
        return "title/titleList";
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public String addNew(Model model){
        TitleForm titleForm = new TitleForm();
        model.addAttribute("titleForm", titleForm);
        return "title/addTitle";
    }

    @PostMapping("/add")
    public String addDepartment(@Valid @ModelAttribute TitleForm titleForm, BindingResult result, Model model){

        if(result.hasErrors()){
            return "title/addTitle";
        }

        if(titleService.validateName(titleForm.getTitleName())){
            result.rejectValue("titleName", "titleNameExist");
            return "title/addTitle";
        }

        titleService.add(titleForm);

        return "redirect:/title/";
    }

    @GetMapping("/showDetail")
    public String showDetail(@RequestParam(name = "titleId") Integer titleId, Model model){

        Title title = titleService.showDetail(titleId);

        TitleForm titleForm = new TitleForm();
        titleForm.setTitleId(title.getTitleId());
        titleForm.setTitleName(title.getTitleName());


        model.addAttribute("titleForm",titleForm);
        return "title/addTitle";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute TitleForm titleForm, BindingResult result,
                         @RequestParam("titleId")Integer titleId, Model model){

        if(result.hasErrors()){
            return "title/addTitle";
        }

        titleService.update(titleForm, titleId);

        return "redirect:/title/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("titleId") Integer titleId){

        titleService.delete(titleId);
        return "title/titleList";
    }
}
