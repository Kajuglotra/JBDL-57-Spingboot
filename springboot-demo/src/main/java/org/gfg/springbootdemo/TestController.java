package org.gfg.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

//@Controller //-> spring
@RestController// --> spring boot -> comb of controller+response body
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    @ResponseBody
    public String getTestMethod(){
        logger.error("Hey !! This is my first log with the time {}" ,new Date() );
        logger.debug("Hey !! This is my first log with the time {}" ,new Date() );
        System.out.println("Kajal");
        return "Dummy text";
    }

    @PostMapping("/getData")
    public String getData(){
        return "abc";
    }
    @GetMapping("/static-data")
    public ModelAndView getStaticData(){
       return new ModelAndView("demo.html");
    }

    @GetMapping("/dynamic-data")
    public ModelAndView getDynamicData(){
        ModelAndView modelAndView = new ModelAndView("ProductPage.html");
        modelAndView.getModelMap().addAttribute("name" , "John");
        return modelAndView;
    }
}
//webapp/WEB-INF/html
// json / xml
