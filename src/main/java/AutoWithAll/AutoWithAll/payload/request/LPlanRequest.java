package AutoWithAll.AutoWithAll.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LPlanRequest {

    @NotNull
    private Long ad_id;

    @NotBlank
    private String l_plan;

    private String description;

    public String getL_plan() {
        return l_plan;
    }

    public void setL_plan(String l_plan) {
        this.l_plan = l_plan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAd_id() {
        return ad_id;
    }

    public void setAd_id(Long ad_id) {
        this.ad_id = ad_id;
    }
}
