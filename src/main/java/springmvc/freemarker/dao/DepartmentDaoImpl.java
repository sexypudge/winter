package springmvc.freemarker.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.freemarker.form.DepartmentForm;
import springmvc.freemarker.model.Department;


import java.io.Serializable;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Department> getListDepartments() {

        return (List<Department>) sessionFactory.getCurrentSession()
            .createCriteria(Department.class)
            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }



    @Override
    public boolean addDepartment(DepartmentForm departmentForm) {

        Session session = sessionFactory.getCurrentSession();

        Department department = new Department();
        department. setDepartmentName(departmentForm.getDepartmentName());

        Serializable s = session.save(department);

        return (Integer.parseInt(s.toString()) > 0);
    }

    @Override
    public Department showDetail(Integer departmentId) {
        Session session = sessionFactory.getCurrentSession();
        Department department = session.get(Department.class, departmentId);
        return department;
    }

    @Override
    public boolean updateDepartment(DepartmentForm departmentForm, Integer departmentId)
    {
        Session session = sessionFactory.getCurrentSession();

        Department department = new Department();
        department.setDepartmentId(departmentId);
        department.setDepartmentName(departmentForm.getDepartmentName());

        session.saveOrUpdate(department);

        return true;
    }

    @Override
    public boolean deleteDepartment(Integer departmentId) {

        Session session = sessionFactory.getCurrentSession();
        Department department = session.get(Department.class, departmentId);

        if(department.getUsers() != null && !department.getUsers().isEmpty()){
            department.getUsers().forEach(user -> {
                user.setDepartment(null);
            });
        }


        session.delete(department);

        return false;
    }

    @Override
    public boolean validateDepartmentName(String departmentName) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Department as d where d.departmentName=?");

        query.setParameter(0, departmentName);


        return query.list().size() > 0;
    }
}
