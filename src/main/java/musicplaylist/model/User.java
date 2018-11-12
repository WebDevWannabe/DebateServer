package musicplaylist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "judge_number")
    private int judgeNumber;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "submit_button_clicked")
    private Boolean isBtnFinalSubmitClicked;

    @Column(name = "logged_in")
    private Boolean isUserLoggedIn;

    public User() {

    }

    public User(int judgeNumber, String username, String password, Boolean isBtnFinalSubmitClicked, Boolean isUserLoggedIn) {
        this.judgeNumber = judgeNumber;
        this.username = username;
        this.password = password;
        this.isBtnFinalSubmitClicked = isBtnFinalSubmitClicked;
        this.isUserLoggedIn = isUserLoggedIn;
    }
    
    public int getJudgeNumber() {
        return judgeNumber;
    }

    public void setJudgeNumber(int judgeNumber) {
        this.judgeNumber = judgeNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getBtnFinalSubmitClicked() {
        return isBtnFinalSubmitClicked;
    }

    public void setBtnFinalSubmitClicked(Boolean btnFinalSubmitClicked) {
        isBtnFinalSubmitClicked = btnFinalSubmitClicked;
    }

    public Boolean getUserLoggedIn() {
        return isUserLoggedIn;
    }

    public void setUserLoggedIn(Boolean userLoggedIn) {
        isUserLoggedIn = userLoggedIn;
    }
}
