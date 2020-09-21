package AutoWithAll.AutoWithAll.payload.request;

import javax.validation.constraints.NotBlank;

public class AdRequest {

    @NotBlank
    private String vehicle_type;

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }
}

