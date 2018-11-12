package musicplaylist.controller;

import musicplaylist.model.Score;
import musicplaylist.repository.ScoreRepository;
import musicplaylist.service.ScoreService;
import musicplaylist.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ScoreController {

    private ScoreService scoreService;
    private TeamService teamService;

    @Autowired
    private void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @Autowired
    private void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }

    @RequestMapping(path = "/submit", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String saveScores (@RequestParam int judgeNumber, @RequestParam String teamName, @RequestParam String collegeName,
                                            @RequestParam double score1, @RequestParam double score2, @RequestParam double score3,
                                            @RequestParam double score4, @RequestParam double scorePercentage1,
                                            @RequestParam double scorePercentage2, @RequestParam double scorePercentage3,
                                            @RequestParam double scorePercentage4, @RequestParam double aveScorePercentage) {

        String teamNameExists = scoreService.findTeamName(teamName, judgeNumber);
        System.out.println("This is called from saveScores()" + teamNameExists);

        if(teamNameExists != null) {
            System.out.println("team name exists");
//            Score score = new Score(teamName, collegeName, score1, score2, score3, score4);

//            System.out.println(score.getTeamName() + ", " + score.getCollegeName() + ", " + + score.getScore1() + ", " +
//                    score.getScore2() + ", " + score.getScore3() + ", " + score.getScore4() + ", " + score.toString());
            scoreService.updateScores(score1, score2, score3, score4, scorePercentage1, scorePercentage2,
                    scorePercentage3, scorePercentage4, aveScorePercentage, teamName, judgeNumber);

            System.out.println("Successfully updated");
        } else {
            System.out.println("team name doesn't exists");
//            Date date = new Date();
//            long dateMillis = date.getTime();
//            String inputNumber = String.valueOf(dateMillis + judgeNumber);
//            System.out.println("saveScores method. input number - " + inputNumber);

            Score score = new Score(judgeNumber, teamName, collegeName, score1, score2, score3, score4, scorePercentage1,
                    scorePercentage2, scorePercentage3, scorePercentage4, aveScorePercentage);

            System.out.println(score.toString());
            scoreService.saveScores(score);

            System.out.println(score.toString() + " successfully saved into DB");
        }

        return "Scores saved!";
    }

    @GetMapping(path = "/scores/{team_name}/{judge_number}")
    public @ResponseBody Score getScoresByTeamName(@PathVariable("team_name") String teamName,
                                                   @PathVariable("judge_number") int judgeNumber) {
        System.out.println("Reading user with teamName " + teamName + " and judgeNumber " + judgeNumber + " from db");
        return scoreService.findScoresOfTeam(teamName, judgeNumber);
    }

    @RequestMapping(path = "/ave_score_percentages/{judge_number}")
    public @ResponseBody List<Double> getAveScorePercentages(@PathVariable("judge_number") int judgeNumber) {
        List<Double> aveScorePercentages = new ArrayList<Double>();
        List<Double> aveScorePercentagesTemp = scoreService.findAveScorePercentages(judgeNumber);
        List<Integer> addIndex = new ArrayList<Integer>();
//        List<Boolean> isTrueOrFalse = new ArrayList<Boolean>();
//        getList(judgeNumber, isTrueOrFalse);
//
//        for(Boolean isTrueOrFalseTemp : isTrueOrFalse) {
//            if(isTrueOrFalseTemp) {
//                aveScorePercentages.add(aveScorePercentagesTemp.get(0));
//                aveScorePercentagesTemp.remove(0);
//            }
//        }
        String[] teamNameForAveScorePercentages = scoreService.findTeamNameForAveScorePercentage(judgeNumber);
        String[] teamNames = teamService.findTeamNames();
        Boolean isAdded = false;

        for(int i = 0; i < teamNames.length; i++) {
            for(int j = 0; j < teamNameForAveScorePercentages.length; j++) {
                if(teamNames[i] == teamNameForAveScorePercentages[j]) {
//                    addTrueOrFalse.add(true);
                    // Add index j
                    addIndex.add(j);
                    System.out.println(teamNames[i] + " is == to " + teamNameForAveScorePercentages[j] +
                            " Added to isAveScorePercentages true");
                    isAdded = true;
                }
            }
            if(!isAdded) {
//                addTrueOrFalse.add(false);
                // Add -1
                addIndex.add(-1);
                System.out.println(teamNames[i] + " is == to " + " Added to isAveScorePercentages false");
            }
            isAdded = false;

            System.out.println(addIndex.size() + " size of list");
            if(addIndex.size() == teamNames.length) {
                break;
            }
        }

        for(int addIndexTemp : addIndex) {
            if(addIndexTemp >= 0) {
                aveScorePercentages.add(aveScorePercentagesTemp.get(addIndexTemp));
            } else {
                aveScorePercentages.add(0.0);
            }
        }
        System.out.println("getAveScorePercentages method. returning aveScorePercentages length - " + aveScorePercentages.size());
        return aveScorePercentages;
    }

//    @RequestMapping(path = "/team_name/ave_score_percentage/{judge_number}")
//    public @ResponseBody String[] getTeamNameForAveScorePercentage(@PathVariable("judge_number") int judgeNumber) {
//        String[] teamName = scoreService.findTeamNameForAveScorePercentage(judgeNumber);
//        System.out.println("getTeamNameForAveScorePercentage method. teamName - " + teamName);
//
//        return teamName;
//    }
//
//    @RequestMapping(path = "/is_ave_score_percentages/{judge_number}")
//    public @ResponseBody List<Boolean> getIsTeamNameForAveScorePercentage(@PathVariable("judge_number") int judgeNumber) {
//        String[] teamNameForAveScorePercentages = scoreService.findTeamNameForAveScorePercentage(judgeNumber);
//        String[] teamNames = teamService.findTeamNames();
////        List<Double> aveScorePercentages = scoreService.findAveScorePercentages(judgeNumber);
//        List<Boolean> isTeamNameForAveScorePercentages = new ArrayList<Boolean>();
//        Boolean isAdded = false;
//
////        System.out.println("getIsTeamNameForAveScorePercentage method. teamNames length - " + aveScorePercentages.size());
//        for(int i = 0; i < teamNames.length; i++) {
//            for(int j = 0; j < teamNameForAveScorePercentages.length; j++) {
//                if(teamNames[i] == teamNameForAveScorePercentages[j]) {
//                    isTeamNameForAveScorePercentages.add(true);
//                    System.out.println(teamNames[i] + " is == to " + teamNameForAveScorePercentages[j] +
//                            " Added to isAveScorePercentages true");
//                    isAdded = true;
//                }
//            }
//            System.out.println(isTeamNameForAveScorePercentages.size() + " size of list");
//            if(isTeamNameForAveScorePercentages.size() == teamNames.length) {
//                break;
//            }
//            if(!isAdded) {
//                isTeamNameForAveScorePercentages.add(false);
//                System.out.println(teamNames[i] + " is == to " + " Added to isAveScorePercentages false");
//            }
//            isAdded = false;
//        }
//
//        return isTeamNameForAveScorePercentages;
////        List<Boolean> isTeamNameForAveScorePercentages = new ArrayList<Boolean>();
////        getList(judgeNumber, isTeamNameForAveScorePercentages);
////        System.out.println("returning isTeamNameForAveScorePercentages length - " + isTeamNameForAveScorePercentages.size());
////        return isTeamNameForAveScorePercentages;
//    }

//    private void getList(int judgeNumber, List<Boolean> addTrueOrFalse) {
//        String[] teamNameForAveScorePercentages = scoreService.findTeamNameForAveScorePercentage(judgeNumber);
//        String[] teamNames = teamService.findTeamNames();
//        Boolean isAdded = false;
//
//        for(int i = 0; i < teamNames.length; i++) {
//            for(int j = 0; j < teamNameForAveScorePercentages.length; j++) {
//                if(teamNames[i] == teamNameForAveScorePercentages[j]) {
//                    addTrueOrFalse.add(true);
//                    // Add index j
//                    System.out.println(teamNames[i] + " is == to " + teamNameForAveScorePercentages[j] +
//                            " Added to isAveScorePercentages true");
//                    isAdded = true;
//                }
//            }
//            if(!isAdded) {
//                addTrueOrFalse.add(false);
//                // Add -1
//                System.out.println(teamNames[i] + " is == to " + " Added to isAveScorePercentages false");
//            }
//            isAdded = false;
//
//            System.out.println(addTrueOrFalse.size() + " size of list");
//            if(addTrueOrFalse.size() == teamNames.length) {
//                break;
//            }
//        }
//    }

//    private List<Double> addAveScorePercentages(double aveScore) {
//        List<Double> aveScorePercentages = new ArrayList<Double>();
//
//
//
//        return aveScorePercentages;
//    }
}
