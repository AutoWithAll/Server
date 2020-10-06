package AutoWithAll.AutoWithAll.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "iplan")

public class IPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String plan_amt;

    @NotBlank
    private String no_of_installments;

    @NotBlank
    private String interest;

    @NotBlank
    private String inst_amt;

    private String description;

    @ManyToOne
    private User user;

    @OneToOne
    private Advertisement advertisement;

    public IPlan() {
    }

    public IPlan(@NotBlank String plan_amt, @NotBlank String no_of_installments, @NotBlank String interest, @NotBlank String inst_amt, String description, User user, Advertisement advertisement) {
        this.plan_amt = plan_amt;
        this.no_of_installments = no_of_installments;
        this.interest = interest;
        this.inst_amt = inst_amt;
        this.description = description;
        this.user = user;
        this.advertisement = advertisement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlan_amt() {
        return plan_amt;
    }

    public void setPlan_amt(String plan_amt) {
        this.plan_amt = plan_amt;
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

    public String getInst_amt() {
        return inst_amt;
    }

    public void setInst_amt(String inst_amt) {
        this.inst_amt = inst_amt;
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
