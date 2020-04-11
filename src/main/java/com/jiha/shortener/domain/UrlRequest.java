package com.jiha.shortener.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class UrlRequest {

    /**
     * 요청 ID
     */
    @Id
    @GeneratedValue
    private Long requestId;

    /**
     * Short URL key
     */
    private String urlKey;

    /**
     * 요청시간
     */
    private LocalDateTime requestTime = LocalDateTime.now();


    public UrlRequest(String urlKey) {
        this.urlKey = urlKey;
    }
}
