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
    private String l_plan;

    private String description;

    @ManyToOne
    private User user;

    @ManyToOne
    private Advertisement advertisement;

    public LPlan() {
    }

    public LPlan(@NotBlank String l_plan, String description, User user,Advertisement advertisement) {
        this.l_plan = l_plan;
        this.description = description;
        this.user = user;
        this.advertisement=advertisement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
