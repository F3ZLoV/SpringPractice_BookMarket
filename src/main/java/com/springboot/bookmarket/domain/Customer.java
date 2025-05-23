package com.springboot.bookmarket.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                        // 아이디
    private String customerId;              // 고객 아이디
    private String name;                    // 고객 이름
    private String phone;                   // 고객 전화번호
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;                // 고객 주소 객체
}
