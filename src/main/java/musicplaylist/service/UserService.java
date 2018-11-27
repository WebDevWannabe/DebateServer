package musicplaylist.service;

import java.util.List;

public interface UserService {
    String findJudgeNumber(String username, String password);

    Boolean findUserLoggedIn(int judgeNumber);

    void updateUserLoggedIn(Boolean isUserLoggedIn, int judgeNumber);

    Boolean findBtnFinalSubmitClicked(int judgeNumber);

    List<Boolean> findAllBtnFinalSubmitClicked();

    void updateBtnSubmitClickedTrue(int judgeNumber);

    void updateBtnSubmitClickedFalse(int judgeNumber);
}
