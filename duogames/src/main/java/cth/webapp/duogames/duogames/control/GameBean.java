package cth.webapp.duogames.duogames.control;


import cth.webapp.duogames.duogames.database.dao.GameDAO;
import cth.webapp.duogames.duogames.view.QuizData;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;



public abstract class GameBean<E>{
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


}