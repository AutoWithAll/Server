package AutoWithAll.AutoWithAll.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class IPlanRequest {
    @NotNull
    private Long ad_id;

    @NotBlank


    private String plan_amt;

    private String no_of_installments;

    private String interest;

    private  String inst_amt;

    private String description;





    public String getPlan_amt() {
        return plan_amt;
    }

    public void setPlan_amt(String plan_amt) {
        this.plan_amt = plan_amt;
    }

    public String getNo_of_installments() { return no_of_installments; }

    public void setNo_of_installments(String no_of_installments) { this.no_of_installments = no_of_installments; }

    public String getInterest() { return interest; }

    public void setInterest(String interest) { this.interest = interest; }

    public String getInst_amt() { return inst_amt; }

    public void setInst_amt(String inst_amt) { this.inst_amt = inst_amt; }

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
