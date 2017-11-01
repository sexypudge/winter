package springmvc.freemarker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.freemarker.dao.PositionDao;
import springmvc.freemarker.form.PositionForm;
import springmvc.freemarker.model.Position;

import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;
    @Override
    public List<Position> getList() {

        return positionDao.getList();
    }

    @Override
    public boolean add(PositionForm positionForm) {

        return positionDao.add(positionForm);
    }

    @Override
    public Position showDetail(Integer positionId) {

        return positionDao.showDetail(positionId);
    }

    @Override
    public boolean update(PositionForm positionForm, Integer positionId) {

        return positionDao.update(positionForm,positionId);
    }

    @Override
    public boolean delete(Integer positionId)
    {
        return positionDao.delete(positionId);
    }

    @Override
    public boolean validateName(String positionName) {

        return positionDao.validateName(positionName);
    }
}
