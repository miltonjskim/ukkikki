package com.dancing_orangutan.ukkikki.member.domain.refreshToken;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RefreshToken {
    private String email;
    private int userId;
    private String refreshToken;
    private long expiration;

    @Builder
    public RefreshToken(String email, Integer userId, String refreshToken, long expiration) {
        this.email = email;
        this.userId = userId;
        this.refreshToken = refreshToken;
        this.expiration = expiration;
    }

}
