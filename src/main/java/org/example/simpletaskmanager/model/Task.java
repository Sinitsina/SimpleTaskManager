package org.example.simpletaskmanager.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotBlank
    private User user;

    @Column(name = "name")
    @NotBlank
    @Size(min = 2, max = 1000)
    private String name;

    @Column(name = "task_date", columnDefinition = "DATE")
    @NotBlank
    private Date date;

    public Task() {
    }

    public Task(Long id, @NotBlank User user,
                @NotBlank @Size(min = 2, max = 1000) String name,
                @NotBlank Date date) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.date = date;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
