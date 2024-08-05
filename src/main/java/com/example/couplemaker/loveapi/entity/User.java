package com.example.couplemaker.loveapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userNo;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String authority;

    private Date reg_date;

    private String address;

    @Column(nullable = false)
    private int gender;

    private String job;

    private String profileImg;

    private Date bornDate;

    private String mbti;


    @Column(length = 400)
    private String refreshToken;

    private Date refreshTokenExpiryDate;

    @Column(precision = 4, scale = 2)
    private BigDecimal score;





}
