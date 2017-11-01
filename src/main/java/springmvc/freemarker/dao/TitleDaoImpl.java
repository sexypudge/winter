package springmvc.freemarker.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.freemarker.form.TitleForm;
import springmvc.freemarker.model.Department;
import springmvc.freemarker.model.Title;

import java.io.Serializable;
import java.util.List;

@Repository
public class TitleDaoImpl implements TitleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Title> getList() {

        return (List<Title>) sessionFactory.getCurrentSession()
            .createCriteria(Title.class)
            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public boolean add(TitleForm titleForm)
    {
        Session session = sessionFactory.getCurrentSession();

        Title title = new Title();
        title. setTitleName(titleForm.getTitleName());

        Serializable s = session.save(title);

        return (Integer.parseInt(s.toString()) > 0);
    }

    @Override
    public Title showDetail(Integer titleId) {
        Session session = sessionFactory.getCurrentSession();
        Title title = session.get(Title.class, titleId);
        return title;
    }

    @Override
    public boolean update(TitleForm titleForm, Integer titleId)
    {
        Session session = sessionFactory.getCurrentSession();

        Title title = new Title();
        title.setTitleId(titleId);
        title.setTitleName(titleForm.getTitleName());

        session.saveOrUpdate(title);

        return true;
    }

    @Override
    public boolean delete(Integer titleId) {
        Session session = sessionFactory.getCurrentSession();
        Title title = session.get(Title.class, titleId);

        if(title.getUsers()!= null && !title.getUsers().isEmpty()){
            title.getUsers().forEach(user -> {
                user.setTitle(null);
            });
        }

        session.delete(title);

        return false;
    }

    @Override
    public boolean validateName(String titleName) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Title as t where t.titleName=?");

        query.setParameter(0, titleName);


        return query.list().size() > 0;
    }
}
