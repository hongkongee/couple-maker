package com.example.couplemaker.loveapi.dto.request;

import com.example.couplemaker.loveapi.entity.Authority;
import com.example.couplemaker.loveapi.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
@EqualsAndHashCode(of = "email")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignUpRequestDTO {

    @NotBlank
    @Size(max = 32)
    private String email;

    @NotBlank
    @Size(max = 20)
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private int gender;

    private String job;

    // 19940401 같은 8글자 생년월일
    private String bornDate;

    private String mbti;

    public User toEntity(String uploadedFilePath) {
        User user = User.builder()
                .email(email)
                .password(password)
                .name(name)
                .authority(Authority.NORMAL)
                .address(address)
                .gender(gender)
                .job(job)
                .profileImg(uploadedFilePath)
                .bornDate(turnIntoDateFormat(bornDate))
                .mbti(mbti)
                .score(BigDecimal.valueOf(0))
                .build();

        return user;
    }

    private Date turnIntoDateFormat(String eightStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setLenient(false); // 엄격한 날짜 파싱을 설정

        try {
            return dateFormat.parse(eightStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}
