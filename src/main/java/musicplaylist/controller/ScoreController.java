package musicplaylist.controller;

import musicplaylist.model.Score;
import musicplaylist.repository.ScoreRepository;
import musicplaylist.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ScoreController {

    private ScoreService scoreService;

    @Autowired
    private void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @RequestMapping(path = "/submit", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String saveScores (@RequestParam String teamName, @RequestParam String collegeName,
                                            @RequestParam double score1, @RequestParam double score2, @RequestParam double score3,
                                            @RequestParam double score4, @RequestParam double scorePercentage1,
                                            @RequestParam double scorePercentage2, @RequestParam double scorePercentage3,
                                            @RequestParam double scorePercentage4, @RequestParam double aveScorePercentage) {

        String teamNameExists = scoreService.findTeamName(teamName);
        System.out.println("This is called from saveScores()" + teamNameExists);

        if(teamNameExists != null) {
            System.out.println("team name exists");
//            Score score = new Score(teamName, collegeName, score1, score2, score3, score4);

//            System.out.println(score.getTeamName() + ", " + score.getCollegeName() + ", " + + score.getScore1() + ", " +
//                    score.getScore2() + ", " + score.getScore3() + ", " + score.getScore4() + ", " + score.toString());
            scoreService.updateScores(score1, score2, score3, score4, scorePercentage1, scorePercentage2,
                    scorePercentage3, scorePercentage4, aveScorePercentage, teamName);

            System.out.println("Successfully updated");
        } else {
            System.out.println("team name doesn't exists");
            Score score = new Score(teamName, collegeName, score1, score2, score3, score4, scorePercentage1, scorePercentage2,
                    scorePercentage3, scorePercentage4, aveScorePercentage);

            System.out.println(score.getTeamName() + ", " + score.getCollegeName() + ", " + + score.getScore1() + ", " +
                    score.getScore2() + ", " + score.getScore3() + ", " + score.getScore4() + ", " + score.toString());
            scoreService.saveScores(score);

            System.out.println(score.toString() + " successfully saved into DB");
        }

        return "Scores saved!";
    }

    @GetMapping(path = "/scores/{team_name}")
    public @ResponseBody Score getScoresByTeamName(@PathVariable("team_name") String teamName) {
        System.out.println("Reading user with id " + teamName + " from db");
        return scoreService.findById(teamName);
    }

    @RequestMapping(path = "/ave_score_percentages")
    public @ResponseBody Double[] getAveScorePercentages() {
        Double[] aveScorePercentages = scoreService.findAveScorePercentages();

        return aveScorePercentages;
    }
}
