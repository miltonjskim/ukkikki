package com.dancing_orangutan.ukkikki.place;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Location {
    private final double latitude;
    private final double longitude;

    // 생성자
    public Location(double latitude, double longitude) {
        if (latitude < -90.0 || latitude > 90.0) {
            throw new IllegalArgumentException("위도는 -90 ~ 90의 값이어야 합니다!!");
        }
        if (longitude < -180.0 || longitude > 180.0) {
            throw new IllegalArgumentException("경도는 -180 ~ 180의 값이어야 합니다!!");
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // 동등성 정의를 위해 equals, hashCode 오버라이딩
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.latitude, latitude) == 0 &&
                Double.compare(location.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    // toString 메서드를 오버라이드하여 Location의 정보를 문자열로 출력
    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
