package com.example.couplemaker.loveapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user_images")
public class UserImages {
    @Id
    @Column(name = "image_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long imageNo;

    // 이미지 주소
    @Column(nullable = false)
    private String image;

    // 이미지 주인 유저
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no", nullable = false)
    private User user;
}
