package com.jiha.shortener.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class UrlRequest {

    /**
     * 요청 ID
     */
    @Id
    @GeneratedValue
    private Long requestId;

    /**
     * URL
     */
    private String urlKey;

    /**
     * 요청시간
     */
    private LocalDateTime requestTime;

    

}
