package com.study.planupassignment.entitiy;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "plan")
public class Plan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 10)
    private String title;

    @Column(nullable = false, length = 50)
    private String contents;

    public Plan() {

    }

    public Plan(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void updatePlan(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
