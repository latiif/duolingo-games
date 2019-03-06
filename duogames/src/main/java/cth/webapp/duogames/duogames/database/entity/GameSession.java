/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stina
 */
@Entity
@Table(name = "gamesessions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameSession.findAll", query = "SELECT g FROM GameSession g"),
    @NamedQuery(name = "GameSession.findById", query = "SELECT g FROM GameSession g WHERE g.id = :id"),
    @NamedQuery(name = "GameSession.findByTime", query = "SELECT g FROM GameSession g WHERE g.time = :time"),
    @NamedQuery(name = "GameSession.findByScore", query = "SELECT g FROM GameSession g WHERE g.score = :score"),
    @NamedQuery(name = "GameSession.findByType", query = "SELECT g FROM GameSession g WHERE g.type = :type")})
public class GameSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    private BigInteger time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "score")
    private int score;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userid;

    public GameSession() {
    }

    public GameSession(Integer id) {
        this.id = id;
    }

    public GameSession(Integer id, BigInteger time, int score, String type) {
        this.id = id;
        this.time = time;
        this.score = score;
        this.type = type;
    }
    
    public GameSession(BigInteger time, int score, String type, User user) {
        this.time = time;
        this.score = score;
        this.type = type;
        this.userid = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getTime() {
        return time;
    }

    public void setTime(BigInteger time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }
    
    public String getTimeInSeconds(){
        return TimeFormatter.format(time.longValue());
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameSession)) {
            return false;
        }
        GameSession other = (GameSession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cth.webapp.duogames.duogames.database.entity.GameSession[ id=" + id + " ]";
    }
    
}
