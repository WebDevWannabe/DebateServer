package musicplaylist.repository;

import musicplaylist.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "select judge_number from users where username = ?1 and password = ?2", nativeQuery = true)
    String findJudgeNumber(String username, String password);

    @Query(value = "select logged_in from users where judge_number = ?1", nativeQuery = true)
    Boolean findUserLoggedIn(int judgeNumber);

    @Modifying
    @Transactional
    @Query(value = "update users set logged_in = ?1 where judge_number = ?2", nativeQuery = true)
    void updateUserLoggedIn(Boolean isUserLoggedIn, int judgeNumber);

    @Query(value = "select submit_button_clicked from users where judge_number = ?1", nativeQuery = true)
    Boolean findBtnFinalSubmitClicked(int judgeNumber);

    @Query(value = "select submit_button_clicked from users", nativeQuery = true)
    List<Boolean> findAllBtnFinalSubmitClicked();

    @Modifying
    @Transactional
    @Query(value = "update users set submit_button_clicked = true where judge_number = ?1", nativeQuery = true)
    void updateBtnSubmitClickedTrue(int judgeNumber);

    @Modifying
    @Transactional
    @Query(value = "update users set submit_button_clicked = false where judge_number = ?1", nativeQuery = true)
    void updateBtnSubmitClickedFalse(int judgeNumber);
}
