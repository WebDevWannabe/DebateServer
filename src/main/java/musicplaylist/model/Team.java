package musicplaylist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teams")
public class Team {
    @Id
    @Column(name = "team_name")
    private String teamName;

    @Column(name = "college_name")
    private String collegeName;

    @Column(name = "college_logo")
    private String collegeLogo;

    public Team() {

    }

    public Team(String teamName, String collegeName) {
        this.teamName = teamName;
        this.collegeName = collegeName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
