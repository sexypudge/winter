package springmvc.freemarker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.freemarker.dao.TitleDao;
import springmvc.freemarker.form.TitleForm;
import springmvc.freemarker.model.Title;

import java.util.List;

@Service
@Transactional
public class TitleServiceImpl implements  TitleService {

    @Autowired
    private TitleDao titleDao;


    @Override
    public List<Title> getList() {
        return titleDao.getList();
    }

    @Override
    public boolean add(TitleForm titleForm) {
        return titleDao.add(titleForm);
    }

    @Override
    public Title showDetail(Integer titleId) {
        return titleDao.showDetail(titleId);
    }

    @Override
    public boolean update(TitleForm titleForm, Integer titleId) {
        return titleDao.update(titleForm, titleId);
    }

    @Override
    public boolean delete(Integer titleId) {
        return titleDao.delete(titleId);
    }

    @Override
    public boolean validateName(String titleName) {
        return titleDao.validateName(titleName);
    }
}
