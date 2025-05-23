package com.springboot.bookmarket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long id;                // 아이디
    private String country;         // 국가명
    private String zipcode;         // 우편번호
    private String addressname;     // 주소
    private String detailname;      // 세부 주소

}
