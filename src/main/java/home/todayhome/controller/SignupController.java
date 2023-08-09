package home.todayhome.controller;

import home.todayhome.dto.user.SignupRequest;
import home.todayhome.service.user.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class SignupController {
    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signUp(@RequestBody SignupRequest signupRequest) {
        userService.signup(signupRequest);
        ApiResponse response = new ApiResponse();
        response.setMessage("회원가입이 완료되었습니다.");
        return ResponseEntity.ok(response);
    }
    public static class ApiResponse {
        private String message;
        public void setMessage(String message) {
            this.message = message;
        }
    }
}
