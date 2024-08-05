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
@Table(name = "tbl_report")
public class Report {

    @Id
    @Column(name = "report_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long reportNo;

    // 신고 사유
    private String reason;

    // 신고 유형
    @Column(nullable = false)
    private String type;

    // 신고한 유저
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no", nullable = false)
    private User user;

    // 신고당한 유저
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reported_user_no", nullable = false)
    private User reportedUser;
    
    
}
