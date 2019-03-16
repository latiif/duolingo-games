package cth.webapp.duogames.duogames.database.entity;

import cth.webapp.duogames.duogames.utils.TimeFormatter;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "gamesessions")
@XmlRootElement

public class GameSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    private BigInteger time;
    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Column(name = "score")
    private int score;
    @Getter
    @Setter
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "type")
    private String type;
    @Getter
    @Setter
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userid;

    public GameSession() {
    }

    public GameSession(BigInteger time, int score, String type, User user) {
        this.time = time;
        this.score = score;
        this.type = type;
        this.userid = user;
    }

    public String getTimeInSeconds() {
        return TimeFormatter.format(time.longValue());
    }
}
