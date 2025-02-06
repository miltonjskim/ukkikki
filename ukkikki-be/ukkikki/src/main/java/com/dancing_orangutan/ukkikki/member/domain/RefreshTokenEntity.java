package com.dancing_orangutan.ukkikki.member.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@RedisHash(value = "refresh_token")
public class RefreshTokenEntity {

    @Id
    private String email;

    @Indexed
    private String refreshToken;

    @TimeToLive
    private long expiration;

    @Builder
    public RefreshTokenEntity(String email, String refreshToken, long expiration) {
        this.email = email;
        this.refreshToken = refreshToken;
        this.expiration = expiration;
    }
}
