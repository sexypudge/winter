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
import springmvc.freemarker.form.PositionForm;
import springmvc.freemarker.form.TitleForm;
import springmvc.freemarker.model.Position;
import springmvc.freemarker.model.Title;
import springmvc.freemarker.service.PositionService;
import springmvc.freemarker.service.TitleService;

import javax.validation.Valid;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("positions", positionService.getList());
        return "position/positionList";
    }

    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public String addNew(Model model){
        PositionForm positionForm = new PositionForm();
        model.addAttribute("positionForm", positionForm);
        return "position/addPosition";
    }

    @PostMapping("/add")
    public String addDepartment(@Valid @ModelAttribute PositionForm positionForm, BindingResult result, Model model){

        if(result.hasErrors()){
            return "position/addPosition";
        }

        if(positionService.validateName(positionForm.getPositionName())){
            result.rejectValue("positionName", "positionNameExist");
            return "position/addPosition";
        }

        positionService.add(positionForm);

        return "redirect:/position/";
    }

    @GetMapping("/showDetail")
    public String showDetail(@RequestParam(name = "positionId") Integer positionId, Model model){

        Position position = positionService.showDetail(positionId);

        PositionForm positionForm = new PositionForm();
        positionForm.setPositionName(position.getPositionName());
        positionForm.setPositionId(position.getPositionId());


        model.addAttribute("positionForm",positionForm);
        return "position/addPosition";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute PositionForm positionForm, BindingResult result,
                         @RequestParam("positionId")Integer positionId, Model model){

        if(result.hasErrors()){
            return "position/addPosition";
        }

        positionService.update(positionForm, positionId);

        return "redirect:/position/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("positionId") Integer positionId){

        positionService.delete(positionId);
        return "position/positionList";
    }
}
