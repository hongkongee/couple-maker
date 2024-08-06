package com.example.couplemaker.loveapi.dto.response;

import com.example.couplemaker.loveapi.entity.User;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "email")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignUpResponseDTO {
    private String email;
    private String name;

    private String address;
    private int gender;
    private String job;
    private String profileImg;
    private Date bornDate;
    private String mbti;

    public UserSignUpResponseDTO(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.address = user.getAddress();
        this.gender = user.getGender();
        this.job = user.getJob();
        this.profileImg = user.getProfileImg();
        this.bornDate = user.getBornDate();
        this.mbti = user.getMbti();

    }
}
