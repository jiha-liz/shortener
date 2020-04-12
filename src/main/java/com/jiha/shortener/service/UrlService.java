package com.jiha.shortener.service;

import com.jiha.common.util.Base62;
import com.jiha.shortener.domain.UrlMatch;
import com.jiha.shortener.domain.UrlRequest;
import com.jiha.shortener.dto.UrlResponseDto;
import com.jiha.shortener.repository.UrlMatchRepository;
import com.jiha.shortener.repository.UrlRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UrlService {

    private final UrlMatchRepository urlMatchRepository;

    private final UrlRequestRepository urlRequestRepository;

    private static final String domain = "http://localhost/";

    /**
     * 새로운 키 생성
     */
    private void createKey(UrlMatch urlMatch) throws Exception {
        urlMatchRepository.save(urlMatch);
        String shortKey = Base62.encode(urlMatch.getId());
        urlMatch.setUrlKey(shortKey);
    }

    /**
     * 요청수 얻기
     */
    private int getReqCnt(String urlKey) {
        return urlRequestRepository.countByUrlKey(urlKey);
    }

    /**
     * URL 변환
     */
    @Transactional
    public UrlResponseDto changeUrl(UrlMatch urlMatch) throws Exception {
        UrlMatch existUrl = urlMatchRepository.findByUrl(urlMatch.getUrl()).orElse(null);
        UrlResponseDto responseDto = UrlResponseDto.builder().build();
        if(existUrl == null) {
            this.createKey(urlMatch);
            responseDto.setChangeUrl(domain+urlMatch.getUrlKey());
        }
        else{
            responseDto.setChangeUrl(domain+existUrl.getUrlKey());
            responseDto.setReqCnt(this.getReqCnt(existUrl.getUrlKey()));
        }
        return responseDto;
    }

    /**
     * 변환된 URL -> 변환전 URL
     */
    @Transactional
    public String getUrlAndAddReq(String urlKey) throws Exception {
        UrlMatch existUrl = urlMatchRepository.findByUrlKey(urlKey).orElse(null);
        if(existUrl == null) throw new Exception("유효한 요청이 아닙니다.");
        UrlRequest urlRequest = new UrlRequest(urlKey);
        urlRequestRepository.save(urlRequest);

        return existUrl.getUrl();
    }

}
