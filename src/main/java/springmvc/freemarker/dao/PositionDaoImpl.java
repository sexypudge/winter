package springmvc.freemarker.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.freemarker.form.PositionForm;
import springmvc.freemarker.model.Position;
import springmvc.freemarker.model.Title;

import java.io.Serializable;
import java.util.List;

@Repository
public class PositionDaoImpl implements PositionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Position> getList() {
        return (List<Position>) sessionFactory.getCurrentSession()
            .createCriteria(Position.class)
            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public boolean add(PositionForm positionForm) {

        Session session = sessionFactory.getCurrentSession();

        Position position = new Position();
        position.setPositionName(positionForm.getPositionName());

        Serializable s = session.save(position);

        return (Integer.parseInt(s.toString()) > 0);
    }

    @Override
    public Position showDetail(Integer positionId) {

        Session session = sessionFactory.getCurrentSession();
        Position position = session.get(Position.class, positionId);
        return position;
    }

    @Override
    public boolean update(PositionForm positionForm, Integer positionId) {

        Session session = sessionFactory.getCurrentSession();

        Position position = new Position();
        position.setPositionId(positionId);
        position.setPositionName(positionForm.getPositionName());

        session.saveOrUpdate(position);

        return true;
    }

    @Override
    public boolean delete(Integer positionId) {

        Session session = sessionFactory.getCurrentSession();
        Position position = session.get(Position.class, positionId);

        if(position.getUsers() != null && !position.getUsers().isEmpty()){
            position.getUsers().forEach(user -> {
                user.setPosition(null);
            });
        }

        session.delete(position);

        return false;
    }

    @Override
    public boolean validateName(String positionName) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Position as p where p.positionName=?");

        query.setParameter(0, positionName);


        return query.list().size() > 0;
    }
}
