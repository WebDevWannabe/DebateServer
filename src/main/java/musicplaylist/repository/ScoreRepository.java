package musicplaylist.repository;

import musicplaylist.model.Score;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//@Repository
public interface ScoreRepository extends CrudRepository<Score, String> {

    @Query(value = "select * from scores where team_name = ?1 and judge_number = ?2", nativeQuery = true)
    Score findScoresOfTeam(String teamName, int judgeNumber);

    @Query(value = "select team_name from scores where team_name = ?1 and judge_number = ?2", nativeQuery = true)
    String findTeamName(String teamName, int judgeNumber);

    @Query(value = "select ave_score_percentage from scores where judge_number = ?1 order by input_number", nativeQuery = true)
    List<Double> findAveScorePercentages(int judgeNumber);

    @Query(value = "select team_name from scores where judge_number = ?1 order by input_number", nativeQuery = true)
    String [] findTeamNameForAveScorePercentage(int judgeNumber);

    @Modifying
    @Transactional
    @Query(value = "update scores set score_1 = ?1, score_2 = ?2, score_3 = ?3, " +
            "score_4 = ?4, score_percentage_1 = ?5, score_percentage_2 = ?6, score_percentage_3 = ?7," +
            "score_percentage_4 = ?8, ave_score_percentage = ?9 where team_name = ?10 and judge_number = ?11", nativeQuery = true)
    void updateScores(double score1, double score2, double score3, double score4, double scorePercentage1,
                      double scorePercentage2, double scorePercentage3, double scorePercentage4,
                      double aveScorePercentage, String teamName, int judgeNumber);
}
