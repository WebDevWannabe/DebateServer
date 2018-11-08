package musicplaylist.model;

import javax.persistence.*;

@Entity
@Table(name = "Scores")
public class Score {

    @Id
    @Column(name = "band_name")
    private String bandName;

    @Column(name = "college_name")
    private String collegeName;

    @Column(name = "criteria_1")
    private double score1;

    @Column(name = "criteria_2")
    private double score2;

    @Column(name = "criteria_3")
    private double score3;

    @Column(name = "criteria_4")
    private double score4;

    public Score() {

    }

    public Score(String bandName, String collegeName, double score1, double score2, double score3, double score4) {
        this.bandName = bandName;
        this.collegeName = collegeName;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
    }

    @Override
    public String toString() {
        return String.format(
                "Score[bandName='%s', collegeName='%s', score1=%.1f, score2=%.1f, score3=%.1f, score4=%.1f]",
                bandName, collegeName, score1, score2, score3, score4);
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

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }

    public double getScore3() {
        return score3;
    }

    public void setScore3(double score3) {
        this.score3 = score3;
    }

    public double getScore4() {
        return score4;
    }

    public void setScore4(double score4) {
        this.score4 = score4;
    }
}
