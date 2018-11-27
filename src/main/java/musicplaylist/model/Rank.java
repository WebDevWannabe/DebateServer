package musicplaylist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rankings")
public class Rank {
    @Id
    @Column(name = "team_name")
    private String teamName;

    @Column(name = "rank")
    private int rank;

    @Column(name = "college_name")
    private String collegeName;

    @Column(name = "final_score")
    private double finalScore;

    public Rank() {

    }

    public Rank(String teamName, int rank, String collegeName, double finalScore) {
        this.teamName = teamName;
        this.rank = rank;
        this.collegeName = collegeName;
        this.finalScore = finalScore;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }
}
