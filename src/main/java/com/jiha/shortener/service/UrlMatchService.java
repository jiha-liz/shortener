package com.jiha.shortener.service;

import com.jiha.shortener.domain.UrlMatch;
import com.jiha.shortener.dto.UrlResponseDto;
import com.jiha.shortener.repository.UrlMatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UrlMatchService {

    private final UrlMatchRepository urlMatchRepository;

    @Transactional
    public UrlResponseDto changeUrl(UrlMatch urlMatch){

        //인코딩결과
        String key = "인코딩결과";
        urlMatch.setKey(key);
        urlMatchRepository.save(urlMatch);

        //get해서 호출수 알아오기

        return null;
    }
}
