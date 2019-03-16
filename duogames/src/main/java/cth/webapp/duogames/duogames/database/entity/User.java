package cth.webapp.duogames.duogames.database.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@XmlRootElement
public class User implements Serializable {

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
    @Size(max = 30)
    @Column(name = "username")
    private String username;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<GameSession> gameSessionCollection;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String username) {
        this.username = username;
    }

    @XmlTransient
    public Collection<GameSession> getGameSessionCollection() {
        return gameSessionCollection;
    }

    public void setGameSessionCollection(Collection<GameSession> gameSessionCollection) {
        this.gameSessionCollection = gameSessionCollection;
    }
}
