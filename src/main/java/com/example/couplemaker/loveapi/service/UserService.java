package com.example.couplemaker.loveapi.service;

import com.example.couplemaker.loveapi.dto.request.UserSignUpRequestDTO;
import com.example.couplemaker.loveapi.dto.response.UserSignUpResponseDTO;
import com.example.couplemaker.loveapi.entity.User;
import com.example.couplemaker.loveapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService {

    @Value("${upload.path}")
    private String uploadRootPath;

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    // 회원가입 유저 등록하기
    @Transactional
    public UserSignUpResponseDTO create(
            final UserSignUpRequestDTO dto, final String uploadedFilePath) {
        String email = dto.getEmail();

        if (isDuplicate(email)) {
            throw new RuntimeException("중복된 이메일 입니다.");
        }

        // 패스워드 인코딩
        String encoded = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encoded);

        // dto를 User Entity로 변환해서 저장.
        User user = userRepository.save(dto.toEntity(uploadedFilePath));
        log.info("회원 가입 정상 수행됨! - saved user - {}", user);
        return new UserSignUpResponseDTO(user);

    }

    //   email 중복 확인 처리
    public boolean isDuplicate(String email) {
        if (userRepository.existsByEmail(email)) {
            log.warn("이메일이 중복되었습니다. - {}", email);
            return true;
        } else return false;
    }

    // 이미지 파일(프로필 사진) 저장하기
    public String uploadProfileImage(MultipartFile profileImage) throws IOException {
        // 루트 디렉토리가 실존하는 지 확인 후 존재하지 않으면 생성.
        File rootDir = new File(uploadRootPath);
        if (!rootDir.exists()) rootDir.mkdirs();

        // 파일명을 유니크하게 변경 (이름 충돌 가능성을 대비)
        // UUID와 원본파일명을 결합
        String uniqueFileName
                = UUID.randomUUID() + "_" + profileImage.getOriginalFilename();
        // 파일 저장
        File uploadFile = new File(uploadRootPath + "/" + uniqueFileName);
        profileImage.transferTo(uploadFile);
        return uploadRootPath + "/" + uniqueFileName;
//      return s3Service.uploadToS3Bucket(profileImage.getBytes(), uniqueFileName);
    }
}
