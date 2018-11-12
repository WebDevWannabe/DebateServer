package musicplaylist.controller;

import musicplaylist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    private void setUserService(UserService userService) {
        this.userService = userService;
    }

    //  Output to be passed on router and will be used as page redirection and saving final score
    @RequestMapping(path = "/judge_number/{username}/{password}")
    public @ResponseBody String getJudgeNumber(@PathVariable("username") String username, @PathVariable("password") String password) {
        String judgeNumber = userService.findJudgeNumber(username, password);

        System.out.println("getJudgeNumber method. username, password, judgeNumber - " + username + ", "
                + password + ", " + judgeNumber);

        String returnString = "";

        if(judgeNumber != null) {
            int judgeNumberTemp = Integer.parseInt(judgeNumber);
            Boolean isBtnFinalSubmitClicked = userService.findBtnFinalSubmitClicked(judgeNumberTemp);

            // Return 1 for true (redirect to /submitted page) and 0 for false (continue to /home page)
            if(isBtnFinalSubmitClicked) {
                returnString = String.valueOf("1" + judgeNumber);
            } else {
                returnString = String.valueOf("0" + judgeNumber);
            }
        } else {
            returnString = "Incorrect Username or Password, try again";
        }

        return returnString;
    }

    //  Output will be used to determine if the judge will be redirected to home or submitted page
//    @RequestMapping(path = "/submit_button_clicked/{judge_number}")
//    public @ResponseBody Boolean getBtnSubmitClicked(@PathVariable("judge_number") int judge_number) {
//        Boolean isBtnFinalSubmitClicked = userService.findBtnFinalSubmitClicked(judge_number);
//        System.out.println("getBtnSubmitClicked method. judge_number, isBtnFinalSubmitClicked - " + judge_number
//                + ", " + isBtnFinalSubmitClicked);
//
//        return isBtnFinalSubmitClicked;
//    }

    @RequestMapping(path = "/user_logged_in/{judge_number}")
    public @ResponseBody Boolean getUserLoggedIn(@PathVariable("judge_number") int judgeNumber) {
        Boolean isUserLoggedIn = userService.findUserLoggedIn(judgeNumber);

        return isUserLoggedIn;
    }

    @RequestMapping(path = "/set_user_logged_in/{logged_in}/{judge_number}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String updateUserLoggedIn(@PathVariable("logged_in") Boolean isUserLoggedIn,
                                                   @PathVariable("judge_number") int judgeNumber) {
        userService.updateUserLoggedIn(isUserLoggedIn, judgeNumber);

        return "User Logged In updated!";
    }

    //  For setting the final submit button as true
    @RequestMapping(path = "/submit_final_score/{judge_number}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String saveFinalScore(@PathVariable("judge_number") int judgeNumber) {
        System.out.println("saveFinalScore method. judgeNumber - " + judgeNumber);
        userService.updateBtnSubmitClicked(judgeNumber);

        return "Final Score Saved!";
    }
}
