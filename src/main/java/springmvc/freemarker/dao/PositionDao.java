package springmvc.freemarker.dao;

import springmvc.freemarker.form.PositionForm;
import springmvc.freemarker.model.Position;

import java.util.List;

public interface PositionDao {

    List<Position> getList();

    boolean add(PositionForm positionForm);

    Position showDetail(Integer positionId);

    boolean update(PositionForm positionForm, Integer positionId);

    boolean delete(Integer positionId);

    boolean validateName(String positionName);
}
