package musicplaylist.service;

import musicplaylist.model.Score;
import musicplaylist.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

    private ScoreRepository scoreRepository;

    @Autowired
    private void setScoreRepository(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @Override
    public Score saveScores(Score score) {
       return scoreRepository.save(score);
    }

    @Override
    public Score findById(String bandName) {
        return scoreRepository.findOne(bandName);
    }

    @Override
    public String findBandName(String bandName) {
        return scoreRepository.findBandName(bandName);
    }

    @Override
    public void updateScores(double score1, double score2, double score3, double score4, String bandName) {
        scoreRepository.updateScores(score1, score2, score3, score4, bandName);
    }
}
