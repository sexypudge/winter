package springmvc.freemarker.service;

import springmvc.freemarker.form.DepartmentForm;
import springmvc.freemarker.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getListDepartments();
    boolean addDepartment(DepartmentForm departmentForm);

    Department showDetail(Integer departmentId);

    boolean updateDepartment(DepartmentForm departmentForm, Integer departmentId);

    boolean deleteDepartment(Integer departmentId);

    boolean validateDepartmentName(String departmentName);
}
