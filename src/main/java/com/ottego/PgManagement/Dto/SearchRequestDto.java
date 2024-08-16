package com.ottego.PgManagement.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequestDto {
    String search_str;
    String city;
    String state;
    String zip;
}
