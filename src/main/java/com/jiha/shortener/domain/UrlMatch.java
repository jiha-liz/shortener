package com.jiha.shortener.domain;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
public class UrlMatch {

    /**
     * URL을 변환한 키
     */
    @Id
    private String key;

    /**
     * 사용자 입력 URL
     */
    private String url;



}
