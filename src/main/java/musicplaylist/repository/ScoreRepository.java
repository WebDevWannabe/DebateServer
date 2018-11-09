package musicplaylist.repository;

import musicplaylist.model.Score;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//@Repository
public interface ScoreRepository extends CrudRepository<Score, String> {

    @Query(value = "select team_name from scores where team_name = ?1", nativeQuery = true)
    String findTeamName(String teamName);

    @Query(value = "select ave_score_percentage from scores", nativeQuery = true)
    Double [] findAveScorePercentages();

    @Modifying
    @Transactional
    @Query(value = "update scores set score_1 = ?1, score_2 = ?2, score_3 = ?3, " +
            "score_4 = ?4, score_percentage_1 = ?5, score_percentage_2 = ?6, score_percentage_3 = ?7," +
            "score_percentage_4 = ?8, ave_score_percentage = ?9 where team_name = ?10", nativeQuery = true)
    void updateScores(double score1, double score2, double score3, double score4, double scorePercentage1,
                      double scorePercentage2, double scorePercentage3, double scorePercentage4,
                      double aveScorePercentage, String teamName);
}
