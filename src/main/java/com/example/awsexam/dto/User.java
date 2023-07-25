package com.example.awsexam.dto;

import com.example.awsexam.domain.posts.BaseTimeEntity;
import com.example.awsexam.domain.user.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name = "users")
public class User extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture= picture;
        this.role= role;
    }

    public User update(String name, String picture){
        this.name= name;
        this.picture =picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
