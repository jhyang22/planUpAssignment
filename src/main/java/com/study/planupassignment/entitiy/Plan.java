package com.study.planupassignment.entitiy;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    public Plan() {

    }

    public Plan(String userName, String title, String contents) {
        this.userName = userName;
        this.title = title;
        this.contents = contents;
    }
}
