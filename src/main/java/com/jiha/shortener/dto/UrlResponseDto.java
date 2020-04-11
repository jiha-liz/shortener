package com.jiha.shortener.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UrlResponseDto {

    /**
     * 도메인 + Shortening key
     */
    private String changeUrl;

    /**
     *  요청 수
     */
    private int reqCnt;


}
