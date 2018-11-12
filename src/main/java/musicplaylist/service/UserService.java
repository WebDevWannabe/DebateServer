package musicplaylist.service;

public interface UserService {
    String findJudgeNumber(String username, String password);

    Boolean findUserLoggedIn(int judgeNumber);

    void updateUserLoggedIn(Boolean isUserLoggedIn, int judgeNumber);

    Boolean findBtnFinalSubmitClicked(int judgeNumber);

    void updateBtnSubmitClicked(int judgeNumber);
}
