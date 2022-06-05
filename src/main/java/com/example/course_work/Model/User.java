package com.example.course_work.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //ссылочный, чтоб мог быть NULL

    private String firstName;
    private String lastName;
    private String profession;
    //private String email;
}


