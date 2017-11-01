package springmvc.freemarker.service;

import springmvc.freemarker.form.PositionForm;
import springmvc.freemarker.form.TitleForm;
import springmvc.freemarker.model.Position;
import springmvc.freemarker.model.Title;

import java.util.List;

public interface PositionService {

    List<Position> getList();

    boolean add(PositionForm positionForm);

    Position showDetail(Integer positionId);

    boolean update(PositionForm positionForm, Integer positionId);

    boolean delete(Integer positionId);

    boolean validateName(String positionName);
}
