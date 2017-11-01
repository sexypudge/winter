package springmvc.freemarker.form;

import org.hibernate.validator.constraints.NotEmpty;

public class TitleForm {

    private Integer titleId;

    @NotEmpty
    private String titleName;

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
