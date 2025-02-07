package com.dancing_orangutan.ukkikki.global.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.Optional;

public class CookieUtils {

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain("fe.i12c204.p.ssafy.io");
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // https 배포시 true로 변경
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        cookie.setAttribute("SameSite", "None");

        response.addCookie(cookie);
        addSubCookie(response, "sub_"+name, value, maxAge);
    }

    public static void addSubCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(false);
        cookie.setSecure(false); // https 배포시 true로 변경
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        cookie.setAttribute("SameSite", "None");

        response.addCookie(cookie);
    }

    /**
     * Refresh Token 쿠키 생성
     */
    public static void addAccessTokenCookie(HttpServletResponse response, String token) {
        addCookie(response, "access_token", token, 24 * 60 * 60);
    }


    /**
     * Refresh Token 쿠키 생성
     */
    public static void addRefreshTokenCookie(HttpServletResponse response, String token) {
        addCookie(response, "refresh_token", token, 7 * 24 * 60 * 60);
    }

    /**
     * 쿠키 삭제
     */
    public static void removeCookie(HttpServletResponse response, String name) {
        addCookie(response, name, null, 0);
    }


    /**
     * 헤더에서 액세스 토큰 추출
     */
    public static Optional<String> getAccessToken(HttpServletRequest request) {
        if (request.getCookies() == null) {
            return Optional.empty();
        }
        return Arrays.stream(request.getCookies())
                .filter(cookie -> "access_token".equals(cookie.getName()))
                .map(Cookie::getValue)
                .findFirst();
    }


    /***
     * 쿠키에서 리프레시 토큰 추출
     */
    public static Optional<String> getRefreshToken(HttpServletRequest request) {
        if (request.getCookies() == null) {
            return Optional.empty();
        }
        return Arrays.stream(request.getCookies())
                .filter(cookie -> "refresh_token".equals(cookie.getName()))
                .map(Cookie::getValue)
                .findFirst();
    }
}
