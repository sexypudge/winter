package springmvc.freemarker.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.freemarker.form.UserForm;
import springmvc.freemarker.model.Department;
import springmvc.freemarker.model.Position;
import springmvc.freemarker.model.Title;
import springmvc.freemarker.model.User;

import java.util.List;
import java.io.Serializable;
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private PositionDao positionDao;

    @Autowired
    private TitleDao titleDao;

    public UserDaoImpl() {

    }

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getListUsers() {
        return (List<User>) sessionFactory.getCurrentSession()
            .createCriteria(User.class)
            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public boolean addUser(UserForm userForm) {

        Session session = sessionFactory.getCurrentSession();

        //user
        User user = new User();
        user.setName(userForm.getName());
        user.setUserName(userForm.getUserName());
        user.setPassword(userForm.getPassword());

        if(userForm.getDepartmentId() != null){
            Department department = departmentDao.showDetail(userForm.getDepartmentId());
            user.setDepartment(department);
        }

        if(userForm.getPositionId() != null){
            Position position = positionDao.showDetail(userForm.getPositionId());
            user.setPosition(position);
        }

        if(userForm.getTitleId() != null){
            Title title = titleDao.showDetail(userForm.getTitleId());
            user.setTitle(title);
        }

        //persist User along with Department
        Serializable s = session.save(user);

        return (Integer.parseInt(s.toString()) > 0);
    }

    @Override
    public User showDetail(Integer userId) {

        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, userId);
        return user;
    }

    @Override
    public boolean updateUser(UserForm userForm, Integer userId) {

        Session session = sessionFactory.getCurrentSession();

        User user = new User();
        user.setUserName(userForm.getUserName());
        user.setPassword(userForm.getPassword());
        user.setName(userForm.getName());
        user.setUserId(userId);

        if(userForm.getDepartmentId() != null){
            Department department = departmentDao.showDetail(userForm.getDepartmentId());
            user.setDepartment(department);
        }

        if(userForm.getDepartmentId() != null){
            Position position = positionDao.showDetail(userForm.getPositionId());
            user.setPosition(position);
        }

        if(userForm.getDepartmentId() != null){
            Title title = titleDao.showDetail(userForm.getTitleId());
            user.setTitle(title);
        }

        session.saveOrUpdate(user);

        return true;
    }

    @Override
    public boolean deleteUser(Integer userId) {

        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, userId);
        session.delete(user);

        return true;
    }

    @Override
    public boolean validateUserName(String userName) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from User as u where u.userName=?");

        query.setParameter(0, userName);

        return query.list().size() > 0;
    }
}
