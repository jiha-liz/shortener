package com.jiha.shortener.domain;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
public class UrlMatch {

    /**
     * ID
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * ID를 인코딩한 결과
     */
    private String urlKey;

    /**
     * 사용자 입력 URL
     */
    private String url;



}
