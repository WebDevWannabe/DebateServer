package musicplaylist.service;

import musicplaylist.model.Score;
import org.springframework.stereotype.Service;

//@Service
public interface ScoreService {
    Score saveScores(Score score);

    Score findById(String teamName);

    String findTeamName(String teamName);

    Double [] findAveScorePercentages();

    void updateScores(double score1, double score2, double score3, double score4, double scorePercentage1,
                      double scorePercentage2, double scorePercentage3, double scorePercentage4,
                      double aveScorePercentage, String teamName);
}
