package AutoWithAll.AutoWithAll.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type ="Bearer";
    private Long id;
    private String fname;
    private String lname;
    private String tnumber;
    private String username;
    private String nic;
    private List<String> roles;

    public JwtResponse(String accessToken,Long id,String fname,String lname,String tnumber,String username,String nic,List<String> roles){
        this.token=accessToken;
        this.id=id;
        this.fname=fname;
        this.lname=lname;
        this.tnumber=tnumber;
        this.username=username;
        this.nic=nic;
        this.roles=roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
