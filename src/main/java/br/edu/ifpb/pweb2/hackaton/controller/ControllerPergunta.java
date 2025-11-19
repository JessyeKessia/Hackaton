package br.edu.ifpb.pweb2.hackaton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/perguntas")
public class ControllerPergunta {
    
    @GetMapping
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
}
