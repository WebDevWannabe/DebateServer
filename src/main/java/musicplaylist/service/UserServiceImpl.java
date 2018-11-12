package musicplaylist.service;

import musicplaylist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String findJudgeNumber(String username, String password) {
        return userRepository.findJudgeNumber(username, password);
    }

    @Override
    public Boolean findUserLoggedIn(int judgeNumber) {
        return userRepository.findUserLoggedIn(judgeNumber);
    }

    @Override
    public void updateUserLoggedIn(Boolean isUserLoggedIn, int judgeNumber) {
        userRepository.updateUserLoggedIn(isUserLoggedIn, judgeNumber);
    }

    @Override
    public Boolean findBtnFinalSubmitClicked(int judgeNumber) {
        return userRepository.findBtnFinalSubmitClicked(judgeNumber);
    }

    @Override
    public void updateBtnSubmitClicked(int judgeNumber) {
        userRepository.updateBtnSubmitClicked(judgeNumber);
    }
}
