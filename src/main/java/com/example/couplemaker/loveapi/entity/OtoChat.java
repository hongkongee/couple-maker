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
    private int chatNo;

    @Column(name = "room_no", nullable = false)
    private int roomNo;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String name;

    @CreationTimestamp
    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user; // userNo

    @Column(name = "`like`", nullable = false)
    private boolean like;

}
