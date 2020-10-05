package AutoWithAll.AutoWithAll.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lplan")
public class LPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String plan_amount;

    private String no_of_installments;

    private String interest;

    private String inst_amount;

    private String description;

    @ManyToOne
    private User user;

    @ManyToOne
    private Advertisement advertisement;

    public LPlan() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LPlan(@NotBlank String plan_amount, String no_of_installments, String interest, String inst_amount, String description, User user, Advertisement advertisement) {
        this.plan_amount = plan_amount;
        this.no_of_installments = no_of_installments;
        this.interest = interest;
        this.inst_amount = inst_amount;
        this.description = description;
        this.user = user;
        this.advertisement = advertisement;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
}
