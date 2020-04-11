package com.jiha.shortener.controller;

import com.jiha.shortener.domain.UrlMatch;
import com.jiha.shortener.dto.UrlResponseDto;
import com.jiha.shortener.service.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@AllArgsConstructor
@Controller
public class MainController {

    private final UrlService urlService;

    @GetMapping("/main")
    public String mainView(){
        return "main";
    }

    @PostMapping("/change")
    public @ResponseBody UrlResponseDto createUrl(@RequestBody UrlMatch urlMatch) throws Exception {
        return urlService.changeUrl(urlMatch);
    }

    @GetMapping("/{urlKey}")
    public RedirectView redirect(@PathVariable("urlKey") String urlKey) throws Exception {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(urlService.getUrlAndAddReq(urlKey));
        return redirectView;
    }

}
