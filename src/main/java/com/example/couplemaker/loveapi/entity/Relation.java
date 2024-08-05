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
@Table(name = "tbl_relation")
public class Relation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relationId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "active_user_no", nullable = false)
    private User activeUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passive_user_no", nullable = false)
    private User passiveUser;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RelationType relationType;

}
