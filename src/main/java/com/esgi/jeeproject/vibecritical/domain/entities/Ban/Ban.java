package com.esgi.jeeproject.vibecritical.domain.entities.Ban;


import com.esgi.jeeproject.vibecritical.domain.entities.User.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ban")
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne()
    private User user;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date bannedDate;

    public Ban(User user, Date bannedDate) {
        this.user = user;
        this.bannedDate = bannedDate;
    }

    public Ban(Long id, User user, Date bannedDate) {
        this.id = id;
        this.user = user;
        this.bannedDate = bannedDate;
    }

    public Ban() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBannedDate() {
        return bannedDate;
    }

    public void setBannedDate(Date bannedDate) {
        this.bannedDate = bannedDate;
    }
}
