package springmvc.freemarker.service;

import springmvc.freemarker.form.DepartmentForm;
import springmvc.freemarker.form.TitleForm;
import springmvc.freemarker.model.Department;
import springmvc.freemarker.model.Title;

import java.util.List;

public interface TitleService {

    List<Title> getList();

    boolean add(TitleForm titleForm);

    Title showDetail(Integer titleId);

    boolean update(TitleForm titleForm, Integer titleId);

    boolean delete(Integer titleId);

    boolean validateName(String titleName);
}
