package home.todayhome.service.user;

import home.todayhome.dto.user.SignupRequest;
import home.todayhome.entity.User;
import home.todayhome.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // 추가
    public void signup(SignupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new RuntimeException("이미 등록된 이메일입니다.");
        }
        User newUser = new User();
        newUser.setEmail(signupRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(signupRequest.getPassword())); // 패스워드 암호화
        userRepository.save(newUser);
    }
}
