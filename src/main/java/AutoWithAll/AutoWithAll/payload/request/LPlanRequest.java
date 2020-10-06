package AutoWithAll.AutoWithAll.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LPlanRequest {

    @NotNull
    private Long ad_id;

    @NotBlank
    private String plan_amount;

    @NotBlank
    private String no_of_installments;

    @NotBlank
    private String interest;

    @NotBlank
    private String inst_amount;

    private String description;

    public Long getAd_id() {
        return ad_id;
    }

    public void setAd_id(Long ad_id) {
        this.ad_id = ad_id;
    }

    public String getPlan_amount() {
        return plan_amount;
    }

    public void setPlan_amount(String plan_amount) {
        this.plan_amount = plan_amount;
    }

    public String getNo_of_installments() {
        return no_of_installments;
    }

    public void setNo_of_installments(String no_of_installments) {
        this.no_of_installments = no_of_installments;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getInst_amount() {
        return inst_amount;
    }

    public void setInst_amount(String inst_amount) {
        this.inst_amount = inst_amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
