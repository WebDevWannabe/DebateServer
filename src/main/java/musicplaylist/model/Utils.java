package musicplaylist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Utils")
public class Utils {
    @Id
    @Column(name = "system_title")
    private String systemTitle;

    @Column(name = "percentage_criteria_1")
    private double percentageCriteria1;

    @Column(name = "percentage_criteria_2")
    private double percentageCriteria2;

    @Column(name = "percentage_criteria_3")
    private double percentageCriteria3;

    @Column(name = "percentage_criteria_4")
    private double percentageCriteria4;

    public Utils() {

    }

    public Utils(String systemTitle, double percentageCriteria1, double percentageCriteria2, double percentageCriteria3,
                 double percentageCriteria4) {
        this.systemTitle = systemTitle;
        this.percentageCriteria1 = percentageCriteria1;
        this.percentageCriteria2 = percentageCriteria2;
        this.percentageCriteria3 = percentageCriteria3;
        this.percentageCriteria4 = percentageCriteria4;
    }

    public String getSystemTitle () {
        return systemTitle;
    }

    public void setSystemTitle (String systemTitle){
        this.systemTitle = systemTitle;
    }

    public double getPercentageCriteria1 () {
        return percentageCriteria1;
    }

    public void setPercentageCriteria1 ( double percentageCriteria1){
        this.percentageCriteria1 = percentageCriteria1;
    }

    public double getPercentageCriteria2 () {
        return percentageCriteria2;
    }

    public void setPercentageCriteria2 ( double percentageCriteria2){
        this.percentageCriteria2 = percentageCriteria2;
    }

    public double getPercentageCriteria3 () {
        return percentageCriteria3;
    }

    public void setPercentageCriteria3 ( double percentageCriteria3){
        this.percentageCriteria3 = percentageCriteria3;
    }

    public double getPercentageCriteria4 () {
        return percentageCriteria4;
    }

    public void setPercentageCriteria4 ( double percentageCriteria4){
        this.percentageCriteria4 = percentageCriteria4;
    }
}