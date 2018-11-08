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
    public @ResponseBody String saveScores (@RequestParam String bandName, @RequestParam String collegeName,
                                            @RequestParam double score1, @RequestParam double score2,
                                            @RequestParam double score3, @RequestParam double score4) {

        String bandNameExists = scoreService.findBandName(bandName);
        System.out.println("This is called from saveScores()" + bandNameExists);

        if(bandNameExists != null) {
            System.out.println("band name exists");
//            Score score = new Score(bandName, collegeName, score1, score2, score3, score4);

//            System.out.println(score.getBandName() + ", " + score.getCollegeName() + ", " + + score.getScore1() + ", " +
//                    score.getScore2() + ", " + score.getScore3() + ", " + score.getScore4() + ", " + score.toString());
            scoreService.updateScores(score1, score2, score3, score4, bandName);

            System.out.println("Successfully updated");
        } else {
            System.out.println("band name doesn't exists");
            Score score = new Score(bandName, collegeName, score1, score2, score3, score4);

            System.out.println(score.getBandName() + ", " + score.getCollegeName() + ", " + + score.getScore1() + ", " +
                    score.getScore2() + ", " + score.getScore3() + ", " + score.getScore4() + ", " + score.toString());
            scoreService.saveScores(score);

            System.out.println(score.toString() + " successfully saved into DB");
        }

        return "Scores saved!";
    }

    @GetMapping(path="/scores/{band_name}")
    public @ResponseBody Score getScoresByBandName(@PathVariable("band_name") String bandName) {
        System.out.println("Reading user with id " + bandName + " from db");
        return scoreService.findById(bandName);
    }
}
