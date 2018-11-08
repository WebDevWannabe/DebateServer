package musicplaylist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bands")
public class Band {
    @Id
    @Column(name = "band_name")
    private String bandName;

    @Column(name = "college_name")
    private String collegeName;

    @Column(name = "college_logo")
    private String collegeLogo;

    public Band() {

    }

    public Band(String bandName, String collegeName) {
        this.bandName = bandName;
        this.collegeName = collegeName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeLogo() {
        return collegeLogo;
    }

    public void setCollegeLogo(String collegeLogo) {
        this.collegeLogo = collegeLogo;
    }
}
