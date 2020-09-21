package AutoWithAll.AutoWithAll.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "advertisement")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String vehicle_type;

//    @NotBlank
//    private  String name;
//
//    @NotBlank
//    private String tnumber;
//
//    @NotBlank
//    private String email;
//
//    @NotBlank
//    private String location;

//    @NotBlank
//    private String;

    @ManyToOne
    private User user;

    public Advertisement(){}

    public Advertisement(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public Advertisement(@NotBlank String vehicle_type, User user) {
        this.vehicle_type = vehicle_type;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
