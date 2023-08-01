package com.travelvcommerce.userservice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import com.travelvcommerce.userservice.entity.Role;
import com.travelvcommerce.userservice.security.CustomUser;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class UserDto {
    private int id;
    private String userId;
    private String email;
    private String nickname;
    private String password;
    private LocalDate birthdate;
    private Role role;
    private String provider;
    private String providerId;
    private TokenDto tokenDto;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String formattedCreatedAt;
    private String formattedUpdatedAt;

    private Collection<? extends GrantedAuthority> authorities;

    @Data
    public static class UserLoginRequestDto {
        private String email;
        private String password;
    }

    @Data
    public static class UserRegisterRequestDto {
        private String email;
        private String password;
        private String nickname;
        private LocalDate birthdate;
        private Role role;
        private String provider;
        private String providerId;
    }

    @Data
    public static class UserInfoResponseDto{
        private String email;
        private String nickname;
        private LocalDate birthdate;
        private Role role;
        private String provider;
    }

    @Data
    public static class UserRegisterResponseDto{
        private String userId;
        private LocalDateTime createdAt;

        public String getFormattedCreatedAt() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
            return createdAt.format(formatter);
        }
    }

    @Data
    public static class UserUpdateRequestDto{
        private String email;
        private String nickname;
        private LocalDate birthdate;
    }

    @Data
    public static class UserUpdateResponseDto{
        private String userId;
        private LocalDateTime updatedAt;
        public String getFormattedUpdatedAt() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
            return updatedAt.format(formatter);
        }
    }

    @Data
    public static class UserUpdatePasswordRequestDto{
        private String email;
        private String password;
    }
    @Data
    public static class UserUpdatePasswordResponseDto{
        private String userId;
        private LocalDateTime updatedAt;

        public String getFormattedUpdatedAt() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
            return updatedAt.format(formatter);
        }
    }

    @Data
    public static class UserDeleteRequestDto{
        private String password;
    }
}
