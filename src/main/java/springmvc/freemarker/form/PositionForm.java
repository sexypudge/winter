package springmvc.freemarker.form;

import org.hibernate.validator.constraints.NotEmpty;

public class PositionForm {

    private Integer positionId;

    @NotEmpty
    private String positionName;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
