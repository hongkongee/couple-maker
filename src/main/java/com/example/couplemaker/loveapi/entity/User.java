package com.example.couplemaker.loveapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
    @Column(name = "user_no")
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

    @Column(name = "reg_date")
    @CreationTimestamp
    private Date regDate;

    private String address;

    @Column(nullable = false)
    private int gender;

    private String job;

    @Column(name = "profile_img")
    private String profileImg;

    @Column(name = "born_date")
    private Date bornDate;

    private String mbti;


    @Column(name = "refresh_token", length = 400)
    private String refreshToken;

    @Column(name = "refresh_token_expiry_date")
    private Date refreshTokenExpiryDate;

    @Column(precision = 4, scale = 2)
    private BigDecimal score;





}
