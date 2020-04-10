package com.jiha.shortener.controller;

import com.jiha.shortener.domain.UrlMatch;
import com.jiha.shortener.dto.UrlResponseDto;
import com.jiha.shortener.service.UrlMatchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@AllArgsConstructor
@Controller
public class MainController {

    private UrlMatchService urlMatchService;

    @GetMapping("/main")
    public String mainView(){
        return "main";
    }

    @PostMapping("/change")
    public @ResponseBody UrlResponseDto changeUrl(@RequestBody UrlMatch urlMatch){
        return urlMatchService.changeUrl(urlMatch);
    }




}
