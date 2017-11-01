package springmvc.freemarker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public boolean checkLogin(String userName, String userPassword) {

        boolean userFound = false;
        //Query using Hibernate Query Language

        Query query = sessionFactory.getCurrentSession().createQuery("from User as u where u.userName=? and u.password=?");

        query.setParameter(0,userName);
        query.setParameter(1,userPassword);

        List list = query.list();

        if ((list != null) && (list.size() > 0)) {
            userFound= true;
        }

        return userFound;
    }
}
