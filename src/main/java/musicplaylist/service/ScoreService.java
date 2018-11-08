package musicplaylist.service;

import musicplaylist.model.Score;
import org.springframework.stereotype.Service;

//@Service
public interface ScoreService {
    Score saveScores(Score score);

    Score findById(String bandName);

    String findBandName(String bandName);

    void updateScores(double score1, double score2, double score3, double score4, String bandName);
}
