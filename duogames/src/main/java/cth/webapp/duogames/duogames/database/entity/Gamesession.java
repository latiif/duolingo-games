/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cth.webapp.duogames.duogames.database.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stina
 */
@Entity
@Table(name = "gamesession")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gamesession.findAll", query = "SELECT g FROM Gamesession g"),
    @NamedQuery(name = "Gamesession.findById", query = "SELECT g FROM Gamesession g WHERE g.id = :id"),
    @NamedQuery(name = "Gamesession.findByIsfinished", query = "SELECT g FROM Gamesession g WHERE g.isfinished = :isfinished"),
    @NamedQuery(name = "Gamesession.findByTime", query = "SELECT g FROM Gamesession g WHERE g.time = :time"),
    @NamedQuery(name = "Gamesession.findByScore", query = "SELECT g FROM Gamesession g WHERE g.score = :score")})
public class Gamesession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isfinished")
    private boolean isfinished;
    @Basic(optional = false)
    @Column(name = "time")
    private long time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "score")
    private short score;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userid;

    public Gamesession() {
    }

    public Gamesession(Integer id) {
        this.id = id;
    }

    public Gamesession(Integer id, boolean isfinished, long time, short score) {
        this.id = id;
        this.isfinished = isfinished;
        this.time = time;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsfinished() {
        return isfinished;
    }

    public void setIsfinished(boolean isfinished) {
        this.isfinished = isfinished;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public short getScore() {
        return score;
    }

    public void setScore(short score) {
        this.score = score;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
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
        if (!(object instanceof Gamesession)) {
            return false;
        }
        Gamesession other = (Gamesession) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cth.webapp.duogames.duogames.database.entity.Gamesession[ id=" + id + " ]";
    }
    
}
