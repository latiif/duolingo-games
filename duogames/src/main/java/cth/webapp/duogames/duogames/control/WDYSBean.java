package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.model.IQuestion;
import cth.webapp.duogames.duogames.model.listening.WhatDidYouSayQuiz;
import cth.webapp.duogames.duogames.utils.ScoreCalculator;
import cth.webapp.duogames.duogames.utils.TimeFormatter;
import cth.webapp.duogames.duogames.view.QuizData;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import net.bootsfaces.utils.FacesMessages;

@Named(value = "wdys")
@SessionScoped
public class WDYSBean extends GameBean implements Serializable {

    @Getter
    @Setter
    private String answer;
    @Inject
    private ScoreBean scorebean;
    private QuizData quizData;
    private Timestamp startTime;
    private Timestamp endTime;
    @Getter
    private final String type = "wdys";
    private final int TOTAL_QUESTIONS = 10;

    public List<IQuestion> initQuiz(UserBean ub) {
        scorebean.setGamebean(this);
        quizData = super.getQuizData();
        if (quizData.getIQuiz() == null) {
            quizData.setIQuiz(startGame());
        }
        return quizData.getIQuiz();
    }

    @Override
    public List<IQuestion> startGame() {
        Map<String, List<String>> dict = super.getUserBean().getApi().getDictionaryOfKnownWords("en", super.getUserBean().getApi().getCurrentLanguage());
        quizData.setCurrQuestion(0);
        quizData.setNrCorrect(0);
        quizData.setTotalQuestions(TOTAL_QUESTIONS);
        quizData.setAnswer("");
        startTime = new Timestamp(System.currentTimeMillis());

        return new WhatDidYouSayQuiz(dict, TOTAL_QUESTIONS).generateQuestions(super.getUserBean().getApi());
    }

    @Override
    public void resetGame() {
        quizData.setIQuiz(null);
        redirect("/duogames/play.xhtml");
    }

    /**
     * *
     * Checks if the typed word is the correct translation. Ends the game if all
     * questions have been answered.
     */
    public void validate() {
        if (quizData.getIQuiz().get(quizData.getCurrQuestion()).check(super.getQuizData().getAnswer())) {
            FacesMessages.info("Correct!");
            int x = quizData.getNrCorrect() + 1;
            quizData.setNrCorrect(x);
            int y = quizData.getCurrQuestion() + 1;
            quizData.setCurrQuestion(y);
            if (quizData.getCurrQuestion() == TOTAL_QUESTIONS) {
                endGame();
            }
        } else {
            FacesMessages.error("Wrong");
            quizData.setCurrQuestion(quizData.getCurrQuestion() + 1);
            if (quizData.getCurrQuestion() == TOTAL_QUESTIONS) {
                endGame();
            }
        }
    }

    /**
     * *
     * Adds gametime, score and gametype to database, then redirects the user to
     * the score page.
     */
    @Override
    public void endGame() {
        endTime = new Timestamp(System.currentTimeMillis());
        long diff = (endTime.getTime() - startTime.getTime());
        long seconds = diff / 1000L;
        quizData.setTime(TimeFormatter.format(seconds));
        quizData.setScore(ScoreCalculator.calculateScore(quizData.getNrCorrect(), diff));
        addToDatabase(quizData.getScore(), seconds, type);
        quizData.setIQuiz(null);
        redirect("/duogames/score.xhtml");
    }
}
