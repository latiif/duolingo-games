package cth.webapp.duogames.duogames.view;

import cth.webapp.duogames.duogames.utils.AchievementTracker;
import java.io.Serializable;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "userData")
@SessionScoped
public class UserData implements Serializable {

    @Getter
    @Setter
    private String username = "";

    @Getter
    @Setter
    private String password = "";

    @Inject
    private AchievementTracker achieve;

    public Map<String, String> getAchievements() {
        return achieve.getAchievements();
    }
}
