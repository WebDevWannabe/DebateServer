package musicplaylist.repository;

import musicplaylist.model.Rank;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface RankRepository extends CrudRepository<Rank, String> {

    @Query(value = "select ave_score_percentage from scores where team_name = ?1", nativeQuery = true)
    double[] findTeamAveScorePercentages(String teamName);

    @Query(value = "select college_name from teams where team_name = ?1", nativeQuery = true)
    String findCollegeName(String teamName);

    @Query(value = "select final_score from rankings where team_name = ?1", nativeQuery = true)
    double findFinalScore(String teamName);

    @Query(value = "select team_name from rankings order by final_score desc", nativeQuery = true)
    String[] findTeamNames();

    @Query(value = "select college_name from rankings order by final_score desc", nativeQuery = true)
    String[] findCollegeNames();

    @Query(value = "select rank from rankings order by rank", nativeQuery = true)
    int[] findRanks();

    @Query(value = "select final_score from rankings order by rank", nativeQuery = true)
    double[] findFinalScores();

    @Query(value = "select final_score from rankings group by final_score having count (*) > 1 order by final_score desc",
            nativeQuery = true)
    List<Double> findTiedFinalScores();

    @Query(value = "select count(*) as final_score_count from rankings group by final_score having count (*) > 1 order by final_score desc",
            nativeQuery = true)
    int[] findTiedFinalScoresCount();

    @Query(value = "select ave_score_percentage from scores where judge_number = ?1 and team_name = ?2", nativeQuery = true)
    double findTiedAveScorePercentage(int judgeNumber, String tiedTeamName);

    @Query(value = "select rank from rankings where final_score = ?1", nativeQuery = true)
    int[] findTiedRank(double tiedFinalScore);

    @Query(value = "select team_name from rankings where final_score = ?1", nativeQuery = true)
    String[] findTeamName(double tiedFinalScore);

    @Query(value = "select college_name from rankings where team_name = ?1", nativeQuery = true)
    String findCollegeNameInRankings(String tiedTeamName);

    @Modifying
    @Transactional
    @Query(value = "update rankings set rank = ?1 where team_name = ?2", nativeQuery = true)
    void updateRank(int rank, String teamName);
}
