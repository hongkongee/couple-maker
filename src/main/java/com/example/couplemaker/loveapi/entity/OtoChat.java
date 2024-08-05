package com.example.couplemaker.loveapi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_oto_chat")
public class OtoChat {

    @Id
    @Column(name = "chat_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long chatNo;

    // 채팅방 번호
    @Column(name = "room_no", nullable = false)
    private int roomNo;

    // 채팅 내용
    @Column(nullable = false)
    private String content;

    // 채팅 등록일
    @CreationTimestamp
    @Column(nullable = false)
    private Date date;

    // 채팅 작성자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer", nullable = false)
    private User user; // userNo

    // 채팅 좋아요
    @Column(name = "`like`", nullable = false)
    private boolean like;

}
