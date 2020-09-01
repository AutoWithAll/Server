package AutoWithAll.AutoWithAll.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {
    @NotBlank
    @Size(max = 50)
    private String fname;

    @NotBlank
    @Size(max = 50)
    private String lname;

    @NotBlank
    @Size(max = 15)
    private String tnumber;

    @NotBlank
    @Size(max = 20)
    private String nic;

    @NotBlank
    @Size(max = 50)
    private String  username;

    @NotBlank
    @Size(min = 6 , max = 40)
    private String password;

    private Set<String> role;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getTnumber() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
