package com.jiha.shortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//@AllArgsConstructor
@Controller
public class MainController {


    @GetMapping("/main")
    public String mainView(){


        return "main";
    }


    public ModelAndView main(){


        return new ModelAndView();
    }


}
