package musicplaylist.repository;

import musicplaylist.model.Score;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//@Repository
public interface ScoreRepository extends CrudRepository<Score, String> {

    @Query(value = "select band_name from scores where band_name = ?1", nativeQuery = true)
    String findBandName(String bandName);

    @Modifying
    @Transactional
    @Query(value = "update scores set criteria_1 = ?1, criteria_2 = ?2, criteria_3 = ?3, " +
            "criteria_4 = ?4 where band_name = ?5", nativeQuery = true)
    void updateScores(double score1, double score2, double score3, double score4, String bandName);
}
