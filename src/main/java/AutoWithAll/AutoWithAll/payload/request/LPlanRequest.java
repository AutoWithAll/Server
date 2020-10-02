package AutoWithAll.AutoWithAll.payload.request;

import javax.validation.constraints.NotBlank;

public class LPlanRequest {

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
}
