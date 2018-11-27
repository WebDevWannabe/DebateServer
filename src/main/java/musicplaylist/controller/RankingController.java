package musicplaylist.controller;

import musicplaylist.model.Rank;
import musicplaylist.service.RankService;
import musicplaylist.service.TeamService;
import musicplaylist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.DoubleStream;

@RestController
@RequestMapping("/api")
public class RankingController {

    private List<Double> tiedFinalScores = new ArrayList<Double>();
    private List<Integer> tiedRanks = new ArrayList<Integer>();
    private List<String> tiedTeamNames = new ArrayList<String>();
    private List<String> tiedCollegeNames = new ArrayList<String>();

    private RankService rankService;
    private TeamService teamService;
    private UserService userService;

    @Autowired
    private void setRankService(RankService rankService) {
        this.rankService = rankService;
    }

    @Autowired
    private void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }

    @Autowired
    private void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/rankings/rank")
    public @ResponseBody int[] getRankings() {
        String[] teamNames = teamService.findTeamNames();
        List<Double> finalScores = new ArrayList<Double>();
        List<Boolean> allBtnFinalSubmitClicked =  userService.findAllBtnFinalSubmitClicked();
//        int ranking = 0;

        for(String teamName: teamNames) {
            double[] teamAveScorePercentages = rankService.findTeamAveScorePercentages(teamName);

            // Get collegeName
            String collegeName = rankService.findCollegeName(teamName);

            // Add ave scores then divide by judge numbers
            double finalScore = DoubleStream.of(teamAveScorePercentages).sum();
            System.out.println("Final Score - " + finalScore);
            finalScore = finalScore / allBtnFinalSubmitClicked.size()+1;

            // Save rank
            Rank rank = new Rank(teamName, 0, collegeName, finalScore);
            rankService.saveRank(rank);
            System.out.println("Rank saved");

            // Get final score
            double finalScoreTemp = rankService.findFinalScore(teamName);

            // Add final score
            finalScores.add(finalScoreTemp);
        }

        Collections.sort(finalScores, Collections.reverseOrder());

        // Update team rank
        for(String teamName: teamNames) {
            int ranking = 0;
//            ranking += 1;

            // Get final score
            double finalScoreTemp = rankService.findFinalScore(teamName);

            for(double finalScore : finalScores) {
//                System.out.println("final Score - " + finalScore);
                ranking += 1;
                if(finalScoreTemp == finalScore) {
                    System.out.println("Ranking - " + ranking + ", Team Name - " + teamName + ", Final Score - " + finalScore);
                    rankService.updateRank(ranking, teamName);
                }
            }
        }

        return rankService.findRanks();
    }

    @GetMapping(path = "/rankings/final_score")
    public @ResponseBody double[] getFinalScores() {
        return rankService.findFinalScores();
    }

    @GetMapping(path = "/rankings/team_names")
    public @ResponseBody List<String> getTeamNames() {
        String[] test = rankService.findTeamNames();
        List<String> teamNames = new ArrayList<String>();
        for(String testTemp : test) {
            System.out.println("testTemp -> " + testTemp);
            teamNames.add(testTemp);
        }
        return teamNames;
    }

    @GetMapping(path = "/rankings/college_names")
    public @ResponseBody String[] getCollegeNames() {
        return rankService.findCollegeNames();
    }

    @GetMapping(path = "/rankings/validate")
    public @ResponseBody boolean getValidation() {
        double[] finalScoresTemp = rankService.findFinalScores();
        List<Double> finalScores = new ArrayList<Double>();
        boolean tieBreaker = false;

        for(double finalScore : finalScoresTemp) {
            if(finalScores.isEmpty()) {
                finalScores.add(finalScore);
            } else {
                if(finalScores.contains(finalScore)) {
                    tieBreaker = true;
                    break;
                } else {
                    finalScores.add(finalScore);
                }
            }
        }
        System.out.println("Tie Breaker - > " + tieBreaker);
        return tieBreaker;
    }

    @GetMapping(path = "/tie_breaker/load")
    public @ResponseBody String loadTiedTeamsInfo() {
        tiedTeamNames.clear();
        tiedCollegeNames.clear();
        tiedFinalScores.clear();
        tiedRanks.clear();
        List<Double> tiedFinalScoresTemp = rankService.findTiedFinalScores();
        List<Double> tiedFinalScoreChecker = new ArrayList<Double>();
        int[] tiedFinalScoresCount = rankService.findTiedFinalScoresCount();
        int tiedFinalScoresTempIndex = 0;

        for(int tiedFinalScoresCountTemp : tiedFinalScoresCount) {
            for(int i = 0; i < tiedFinalScoresCountTemp; i++) {
                tiedFinalScores.add(tiedFinalScoresTemp.get(tiedFinalScoresTempIndex));
            }
            tiedFinalScoresTempIndex += 1;
        }
//        List<Integer> tiedRanks = new ArrayList<Integer>();
//        List<String> tiedTeamNames = new ArrayList<String>();
//        List<String> tiedCollegeNames = new ArrayList<String>();
        System.out.println("Tied final scores size -> " + tiedFinalScores.size());
        for(double tiedFinalScore : tiedFinalScores) {

            if(tiedFinalScoreChecker.contains(tiedFinalScore)) {
                System.out.println("tiedFinalScoreChecker already contains -> " + tiedFinalScore);
            } else {
                tiedFinalScoreChecker.add(tiedFinalScore);
                int[] tiedRank = rankService.findTiedRank(tiedFinalScore);

                for(int i = 0; i < tiedRank.length; i++) {
                    if(tiedRank[i] == 1 || tiedRank[i] == 2 || tiedRank[i] == 3) {
                        // Add rank of that final score
                        tiedRanks.add(tiedRank[i]);

                        // Add team name of that final score
                        String[] tiedTeamName = rankService.findTeamName(tiedFinalScore);
                        tiedTeamNames.add(tiedTeamName[i]);

                        // Add college name of that final score
                        String tiedCollegeName = rankService.findCollegeNameInRankings(tiedTeamName[i]);
                        tiedCollegeNames.add(tiedCollegeName);

                        System.out.println("Team name - " + tiedTeamName[i] + ", college name - " + tiedCollegeName + ", final score - " +
                                tiedFinalScore + ", rank - " + tiedRank[i]);
                    }
                }
            }
        }
        System.out.println("Finished populating lists..");

//        getTiedTeamNames(tiedTeamNames);
//        getTiedCollegeNames(tiedCollegeNames);
//        getTiedFinalScores(tiedFinalScores);
//        getTiedRanks(tiedRanks);

        System.out.println("Data passed..");

        return "Tie breaker info loaded!";
    }

    @GetMapping(path = "/tie_breaker/team_names")
    public @ResponseBody List<String> getTiedTeamNames() {
        for(String tiedTeamNamesTemp : tiedTeamNames) {
            System.out.println("Tied team names temp -> " + tiedTeamNamesTemp);
        }
        return tiedTeamNames;
    }

    @GetMapping(path = "/tie_breaker/college_names")
    public @ResponseBody List<String> getTiedCollegeNames() {
        return tiedCollegeNames;
    }

    @GetMapping(path = "/tie_breaker/final_scores")
    public @ResponseBody List<Double> getTiedFinalScores() {
        return tiedFinalScores;
    }

    @GetMapping(path = "/tie_breaker/{judge_number}/ave_score_percentages")
    public @ResponseBody List<Double> getTiedAveScorePercentages(@PathVariable("judge_number") int judge_number) {
        List<Double> tiedAveScorePercentages = new ArrayList<Double>();
        for(String tiedTeamNamesTemp: tiedTeamNames) {
           double tiedAveScorePercentagesTemp = rankService.findTiedAveScorePercentage(judge_number, tiedTeamNamesTemp);
           tiedAveScorePercentages.add(tiedAveScorePercentagesTemp);
        }
        System.out.println("tiedAveScorePercentages size -> " + tiedAveScorePercentages.size());
        return tiedAveScorePercentages;
    }

    @GetMapping(path = "/tie_breaker/ranks")
    public @ResponseBody List<Integer> getTiedRanks() {
        return tiedRanks;
    }
}

















