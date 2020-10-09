package AutoWithAll.AutoWithAll.payload.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class PackagePurchaseRequest {
    private Long pkgId;

    @Column(name="creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;
    private Integer currentAdCount;
    public Long getPkgId(){
        return pkgId;
    }
    public void setPkgId(Long pkgId){
        this.pkgId=pkgId;
    }
    public Date getPurchaseDate(){
        return purchaseDate;
    }
    public void setPurchaseDate(Date purchaseDate){
        this.purchaseDate=purchaseDate;
    }
    public Integer getCurrentAdCount(){
        return currentAdCount;
    }
    public void setCurrentAdCount(Integer currentAdCount){
        this.currentAdCount=currentAdCount;
    }
}
