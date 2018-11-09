package musicplaylist.model;

import javax.persistence.*;

@Entity
@Table(name = "Scores")
public class Score {

    @Id
    @Column(name = "team_name")
    private String teamName;

    @Column(name = "college_name")
    private String collegeName;

    @Column(name = "score_1")
    private double score1;

    @Column(name = "score_2")
    private double score2;

    @Column(name = "score_3")
    private double score3;

    @Column(name = "score_4")
    private double score4;

    @Column(name = "score_percentage_1")
    private double scorePercentage1;

    @Column(name = "score_percentage_2")
    private double scorePercentage2;

    @Column(name = "score_percentage_3")
    private double scorePercentage3;

    @Column(name = "score_percentage_4")
    private double scorePercentage4;

    @Column(name = "ave_score_percentage")
    private double aveScorePercentage;

    public Score() {

    }

    public Score(String teamName, String collegeName, double score1, double score2, double score3, double score4,
                 double scorePercentage1, double scorePercentage2, double scorePercentage3, double scorePercentage4,
                 double aveScorePercentage) {
        this.teamName = teamName;
        this.collegeName = collegeName;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.scorePercentage1 = scorePercentage1;
        this.scorePercentage2 = scorePercentage2;
        this.scorePercentage3 = scorePercentage3;
        this.scorePercentage4 = scorePercentage4;
        this.aveScorePercentage = aveScorePercentage;
    }

    @Override
    public String toString() {
        return String.format(
                "Score[teamName='%s', collegeName='%s', score1=%.1f, score2=%.1f, score3=%.1f, score4=%.1f, scorePercentage1=%.1f," +
                        "scorePercentage2=%.1f, scorePercentage3=%.1f, scorePercentage4=%.1f, aveScorePercentage=%.1f]",
                teamName, collegeName, score1, score2, score3, score4, scorePercentage1, scorePercentage2, scorePercentage3,
                scorePercentage4, aveScorePercentage);
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

    public double getScorePercentage1() {
        return scorePercentage1;
    }

    public void setScorePercentage1(double scorePercentage1) {
        this.scorePercentage1 = scorePercentage1;
    }

    public double getScorePercentage2() {
        return scorePercentage2;
    }

    public void setScorePercentage2(double scorePercentage2) {
        this.scorePercentage2 = scorePercentage2;
    }

    public double getScorePercentage3() {
        return scorePercentage3;
    }

    public void setScorePercentage3(double scorePercentage3) {
        this.scorePercentage3 = scorePercentage3;
    }

    public double getScorePercentage4() {
        return scorePercentage4;
    }

    public void setScorePercentage4(double scorePercentage4) {
        this.scorePercentage4 = scorePercentage4;
    }

    public double getAveScorePercentage() {
        return aveScorePercentage;
    }

    public void setAveScorePercentage(double aveScorePercentage) {
        this.aveScorePercentage = aveScorePercentage;
    }
}
