package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.model.IQuestion;
import cth.webapp.duogames.duogames.model.quiz.Quiz;
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
import org.ocpsoft.common.util.Strings;

@Named(value = "quiz")
@SessionScoped
public class QuizBean extends GameBean implements Serializable {

    @Inject
    private ScoreBean scorebean;
    private QuizData quizData;
    @Getter
    private final String type = "quiz";
    @Getter
    @Setter
    private String gameid;
    private Timestamp startTime;
    private Timestamp endTime;
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
        Map<String, List<String>> dict = super.getUserBean().getApi()
                .getDictionaryOfKnownWords("en", super.getUserBean().getApi().getCurrentLanguage());
        quizData.setCurrQuestion(0);
        quizData.setTotalQuestions(TOTAL_QUESTIONS);
        quizData.setNrCorrect(0);
        quizData.setAnswer("");
        startTime = new Timestamp(System.currentTimeMillis());
        return new Quiz(dict, TOTAL_QUESTIONS, 3).generateQuestions();
    }

    @Override
    public void resetGame() {
        quizData.setIQuiz(null);
        gameid = "";
        redirect("/duogames/play.xhtml");
    }

    public void validate() {
        if (quizData.getIQuiz().get(quizData.getCurrQuestion()).check(quizData.getAnswer())) {
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
            int x = quizData.getCurrQuestion() + 1;
            quizData.setCurrQuestion(x);
            if (quizData.getCurrQuestion() == TOTAL_QUESTIONS) {
                endGame();
            }
        }
    }

    @Override
    public void endGame() {
        endTime = new Timestamp(System.currentTimeMillis());
        long diff = (endTime.getTime() - startTime.getTime());
        long seconds = diff / 1000L;
        quizData.setTime(TimeFormatter.format(seconds));
        quizData.setScore(ScoreCalculator.calculateScore(quizData.getNrCorrect(), diff));
        addToDatabase(quizData.getScore(), seconds, type);
        quizData.setIQuiz(null);
        if (Strings.isNullOrEmpty(gameid)) {
            redirect("/duogames/score.xhtml");
        } else {
            redirect("/duogames/score.xhtml?gameid=" + gameid);
        }
    }
}
