package com.ucbcba.tallerprogra;

/**
 * Created by da_20 on 26/4/2017.
 */
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class example {
    @RequestMapping("/")
    String home() {
        return "Terminals";
    }
}
