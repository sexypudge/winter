package springmvc.freemarker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.freemarker.dao.DepartmentDao;
import springmvc.freemarker.form.DepartmentForm;
import springmvc.freemarker.model.Department;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements  DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> getListDepartments() {
        return departmentDao.getListDepartments();
    }

    @Override
    public boolean addDepartment(DepartmentForm departmentForm) {
        return departmentDao.addDepartment(departmentForm);
    }

    @Override
    public Department showDetail(Integer departmentId) {
        return departmentDao.showDetail(departmentId);
    }

    @Override
    public boolean updateDepartment(DepartmentForm departmentForm, Integer departmentId) {
        return departmentDao.updateDepartment(departmentForm, departmentId);
    }

    @Override
    public boolean deleteDepartment(Integer departmentId) {

        return departmentDao.deleteDepartment(departmentId);
    }

    @Override
    public boolean validateDepartmentName(String departmentName)
    {
        return departmentDao.validateDepartmentName(departmentName);
    }
}
