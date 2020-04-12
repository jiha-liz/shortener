package com.jiha.shortener.controller;

import com.jiha.shortener.domain.UrlMatch;
import com.jiha.shortener.service.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

@AllArgsConstructor
@Controller
public class MainController {

    private final UrlService urlService;

    @GetMapping("/")
    public String mainRedirect(){
        return "main";
    }

    @GetMapping("/main")
    public String mainView(){
        return "main";
    }

    @PostMapping("/change")
    public ResponseEntity  createUrl(@RequestBody UrlMatch urlMatch) throws Exception {
        return ResponseEntity.ok(urlService.changeUrl(urlMatch));
    }

    @GetMapping("/{urlKey}")
    public RedirectView redirect(@PathVariable("urlKey") String urlKey) throws Exception {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(urlService.getUrlAndAddReq(urlKey));
        return redirectView;
    }

}
