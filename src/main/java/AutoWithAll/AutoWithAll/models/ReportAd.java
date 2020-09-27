//package AutoWithAll.AutoWithAll.models;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "reportad")
//public class ReportAd {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank
//    private String reason;
//
//    @NotBlank
//    private String f_name;
//
//    @NotBlank
//    private String l_name;
//
//    @NotBlank
//    private String t_number;
//
//    @NotBlank
//    private String email;
//
//    @NotBlank
//    private String message;
//
////    @ManyToMany
////    Set<Advertisement> report;
//    @ManyToOne
//    @JoinColumn(name = "add_id")
//    private Long ad_id;
//
//
//
//    public ReportAd(){}
//
//    public ReportAd(Long ad_id,@NotBlank String reason, @NotBlank String f_name, @NotBlank String l_name, @NotBlank String t_number, @NotBlank String email, @NotBlank String message) {
//        this.reason = reason;
//        this.f_name = f_name;
//        this.l_name = l_name;
//        this.t_number = t_number;
//        this.email = email;
//        this.message = message;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getReason() {
//        return reason;
//    }
//
//    public void setReason(String reason) {
//        this.reason = reason;
//    }
//
//    public String getF_name() {
//        return f_name;
//    }
//
//    public void setF_name(String f_name) {
//        this.f_name = f_name;
//    }
//
//    public String getL_name() {
//        return l_name;
//    }
//
//    public void setL_name(String l_name) {
//        this.l_name = l_name;
//    }
//
//    public String getT_number() {
//        return t_number;
//    }
//
//    public void setT_number(String t_number) {
//        this.t_number = t_number;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//}
