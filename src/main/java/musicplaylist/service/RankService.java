package musicplaylist.service;

import musicplaylist.model.Rank;

import java.util.List;

public interface RankService {

    Rank saveRank(Rank rank);

    String findCollegeName(String teamName);

    double[] findTeamAveScorePercentages(String teamName);

    double findFinalScore(String teamName);

    String[] findTeamNames();

    String[] findCollegeNames();

    int[] findRanks();

    double[] findFinalScores();

    List<Double> findTiedFinalScores();

    int[] findTiedFinalScoresCount();

    double findTiedAveScorePercentage(int judgeNumber, String tiedTeamName);

    int[] findTiedRank(double tiedFinalScore);

    String[] findTeamName(double tiedFinalScore);

    String findCollegeNameInRankings(String tiedTeamName);

    void updateRank(int rank, String teamName);
}
