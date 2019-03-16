package cth.webapp.duogames.duogames.control;

import cth.webapp.duogames.duogames.database.dao.GameDAO;
import cth.webapp.duogames.duogames.database.entity.GameSession;
import cth.webapp.duogames.duogames.view.QuizData;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

public abstract class GameBean<E> {

    @Inject
    @Getter
    @Setter
    private UserBean userBean;

    @Inject
    @Getter
    @Setter
    private QuizData quizData;

    @EJB
    @Getter
    @Setter
    private GameDAO gameDAO;

    public abstract List<E> startGame();

    public abstract void endGame();

    public abstract void resetGame();

    protected void redirect(String url) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    protected void addToDatabase(int score, long gameTime, String type) {
        GameSession game = new GameSession(BigInteger.valueOf(gameTime), score, type, userBean.getUser());
        gameDAO.add(game);
    }
}
