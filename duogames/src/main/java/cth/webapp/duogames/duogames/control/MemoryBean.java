package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.model.memory.Memory;
import cth.webapp.duogames.duogames.model.memory.Pair;
import cth.webapp.duogames.duogames.utils.ScoreCalculator;
import cth.webapp.duogames.duogames.utils.TimeFormatter;
import cth.webapp.duogames.duogames.view.QuizData;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

@Named(value = "memory")
@SessionScoped
public class MemoryBean extends GameBean implements Serializable {

    @Inject
    private ScoreBean scorebean;
    private QuizData quizData;
    private Timestamp startTime;
    private Timestamp endTime;
    @Getter
    final private int NR_OF_PAIRS = 6;
    @Getter
    final private String type = "pair";
    @Getter
    private List<Pair> pairs;
    private String word = "";
    private String answer = "";
    @Getter
    private boolean result;

    public List<String> getQuizInformation(UserBean ub) {
        scorebean.setGamebean(this);
        quizData = super.getQuizData();
        if (quizData.getQuiz() == null) {
            quizData.setQuiz(startGame());
        }
        return quizData.getQuiz();
    }

    /**
     * *
     * Generates a set amount of word pairs, and returns a shuffled list of
     * every generated pairs word and translation.
     *
     * @return Shuffled list of Strings
     */
    @Override
    public List<String> startGame() {
        Map<String, List<String>> dict = super.getUserBean().getApi()
                .getDictionaryOfKnownWords("en", super.getUserBean().getApi().getCurrentLanguage());
        startTime = new Timestamp(System.currentTimeMillis());
        pairs = new Memory(dict, NR_OF_PAIRS).generatePairs();
        quizData.setQuiz(new ArrayList<>());
        pairs.forEach(p
                -> {
            quizData.getQuiz().add(p.getWord());
            quizData.getQuiz().add(p.getAnswer());
        });
        Collections.shuffle(quizData.getQuiz());
        return quizData.getQuiz();
    }

    /**
     * *
     * Adds gametime, score and gametype to database. Redirects the user.
     */
    @Override
    public void endGame() {
        endTime = new Timestamp(System.currentTimeMillis());
        long diff = (endTime.getTime() - startTime.getTime());
        long seconds = diff / 1000L;
        quizData.setTime(TimeFormatter.format(seconds));
        quizData.setScore(ScoreCalculator.calculateScore(NR_OF_PAIRS * 2, diff));
        addToDatabase(quizData.getScore(), seconds, type);
        redirect("/duogames/score.xhtml");
    }

    @Override
    public void resetGame() {
        quizData.setQuiz(null);
        redirect("/duogames/play.xhtml");
    }

    /**
     * *
     * This method is called from memory.xhtml by Javascript. Checks if the
     * words from the two turned cards are a matching pair. When this method is
     * done, a Javascript function will be called to handle the result.
     */
    public void checkPair() {
        FacesContext context = FacesContext.getCurrentInstance();
        word = context.getExternalContext().getRequestParameterMap().get("word");
        answer = context.getExternalContext().getRequestParameterMap().get("answer");
        for (Pair oldPair : pairs) {
            if (oldPair.getWord().equalsIgnoreCase(word)) {
                result = oldPair.equals(new Pair(word, answer));
                return;
            } else if (oldPair.getAnswer().equalsIgnoreCase(answer)) {
                result = oldPair.equals(new Pair(word, answer));
                return;
            } else if (oldPair.getAnswer().equalsIgnoreCase(word)) {
                result = oldPair.equals(new Pair(answer, word));
                return;
            } else if (oldPair.getWord().equalsIgnoreCase(answer)) {
                result = oldPair.equals(new Pair(answer, word));
                return;
            }
        }
    }
}
