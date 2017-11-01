package springmvc.freemarker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.freemarker.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FilterDaoImpl implements  FilterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> search(Integer de, Integer ti, Integer po) {

        Session session = sessionFactory.getCurrentSession();
        StringBuilder hql = new StringBuilder("from User as u where 1=1 ");

        if(de != null && de > 0){
            hql.append(" and u.department.departmentId =" + de);
        }

        if(ti != null && ti > 0){
            hql.append(" and u.title.titleId =" + ti);
        }

        if(po != null && po > 0){
            hql.append(" and u.position.positionId =" + po);
        }

        Query query = session.createQuery(hql.toString());

        return query.list();
    }
}
