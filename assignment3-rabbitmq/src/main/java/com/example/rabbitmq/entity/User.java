package com.example.rabbitmq.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(generator = "userPk_sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "userPk_sequence", sequenceName = "userPk_sequence", allocationSize = 1)
    private Long userPk;
    @Column(nullable = false)
    private String fullname;
    @Column(nullable = false)
    private String email;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return userPk != null && Objects.equals(userPk, user.userPk);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
