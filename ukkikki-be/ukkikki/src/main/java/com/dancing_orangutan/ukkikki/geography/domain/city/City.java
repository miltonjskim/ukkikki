package com.dancing_orangutan.ukkikki.geography.domain.city;


import lombok.Builder;

public record City(Integer continentId, Integer countryId, Integer cityId, String name) {


    @Builder
    public City{

    }
}
