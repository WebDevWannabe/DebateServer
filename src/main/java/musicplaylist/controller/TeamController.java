package musicplaylist.controller;

import musicplaylist.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TeamController {

    private TeamService teamService;

    @Autowired
    private void setTeamService(TeamService teamService) {
        this.teamService = teamService;
    }

//    @RequestMapping(path = "/hello")
//    public @ResponseBody String sendResponse() {
//        System.out.println("Testing from the controller");
//
//        Boolean test = true;
//        String ID = "Test";
//
//        if(scoreService.findAllQuestions(ID)) {
//            System.out.println(ID + " found");
//        } else {
//            System.out.println(ID + " not found");
//        }
//
//        return "This is the response from the server";
//    }

    @RequestMapping(path = "/team_names")
    public @ResponseBody String[] getTeamNames() {
        String[] teamNames = teamService.findTeamNames();
        int lenTeamNames = teamNames.length;

        do {
            System.out.println(lenTeamNames + " team names current length");
//            System.out.println(teamNames);
            lenTeamNames -= 1;
        } while (lenTeamNames != 0);

        return teamNames;
    }

    @RequestMapping(path = "/college_names")
    public @ResponseBody String[] getCollegeNames() {
        String[] collegeNames = teamService.findCollegeNames();
        int lenCollegeNames = collegeNames.length;

        do {
            System.out.println(lenCollegeNames + " college names current length");
//            System.out.println(collegeNames);
            lenCollegeNames -= 1;
        } while (lenCollegeNames != 0);

        return collegeNames;
    }

    @RequestMapping(path = "/college_logos")
    public @ResponseBody String[] getCollegeLogo() {
        String[] collegeLogo = teamService.findCollegeLogo();
        int lenCollegeLogo = collegeLogo.length;

        do {
            System.out.println(lenCollegeLogo + " college logo current length");
//            System.out.println(collegeLogo);
            lenCollegeLogo -= 1;
        } while (lenCollegeLogo != 0);

        return collegeLogo;
    }
}
