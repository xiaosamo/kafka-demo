package com.yuanshijia.kafkademo.common;

import lombok.*;

/**
 * @author yuan
 * @date 2019/6/3
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company {
    private String name;
    private String address;
}
