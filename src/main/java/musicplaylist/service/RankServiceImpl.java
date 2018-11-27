package musicplaylist.service;

import musicplaylist.model.Rank;
import musicplaylist.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankServiceImpl implements RankService {

    private RankRepository rankRepository;

    @Autowired
    private void setRankRepository(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    @Override
    public Rank saveRank(Rank rank) {
        return rankRepository.save(rank);
    }

    @Override
    public String findCollegeName(String teamName) {
        return rankRepository.findCollegeName(teamName);
    }

    @Override
    public double[] findTeamAveScorePercentages(String teamName) {
        return rankRepository.findTeamAveScorePercentages(teamName);
    }

    @Override
    public double findFinalScore(String teamName) {
        return rankRepository.findFinalScore(teamName);
    }

    @Override
    public String[] findTeamNames() {
        return rankRepository.findTeamNames();
    }

    @Override
    public String[] findCollegeNames() {
        return rankRepository.findCollegeNames();
    }

    @Override
    public int[] findRanks() {
        return rankRepository.findRanks();
    }

    @Override
    public double[] findFinalScores() {
        return rankRepository.findFinalScores();
    }

    @Override
    public List<Double> findTiedFinalScores() {
        return rankRepository.findTiedFinalScores();
    }

    @Override
    public int[] findTiedFinalScoresCount() {
        return rankRepository.findTiedFinalScoresCount();
    }

    @Override
    public double findTiedAveScorePercentage(int judgeNumber, String tiedTeamName) {
        return rankRepository.findTiedAveScorePercentage(judgeNumber, tiedTeamName);
    }

    @Override
    public int[] findTiedRank(double tiedFinalScore) {
        return rankRepository.findTiedRank(tiedFinalScore);
    }

    @Override
    public String[] findTeamName(double tiedFinalScore) {
        return rankRepository.findTeamName(tiedFinalScore);
    }

    @Override
    public String findCollegeNameInRankings(String tiedTeamName) {
        return rankRepository.findCollegeNameInRankings(tiedTeamName);
    }

    @Override
    public void updateRank(int rank, String teamName) {
        rankRepository.updateRank(rank, teamName);
    }
}
