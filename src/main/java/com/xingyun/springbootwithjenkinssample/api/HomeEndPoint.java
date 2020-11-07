package com.xingyun.springbootwithjenkinssample.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qing-feng.zhao
 */
@RestController
public class HomeEndPoint {
    @GetMapping(value = "/")
    public String home(){
        return "home";
    }
}
