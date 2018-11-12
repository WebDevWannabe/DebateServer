package musicplaylist.service;

import musicplaylist.model.Score;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface ScoreService {
    Score saveScores(Score score);

    Score findScoresOfTeam(String teamName, int judgeNumber);

    String findTeamName(String teamName, int judgeNumber);

    List<Double> findAveScorePercentages(int judgeNumber);

    String [] findTeamNameForAveScorePercentage(int judgeNumber);

    void updateScores(double score1, double score2, double score3, double score4, double scorePercentage1,
                      double scorePercentage2, double scorePercentage3, double scorePercentage4,
                      double aveScorePercentage, String teamName, int judgeNumber);
}
