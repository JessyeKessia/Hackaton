package br.edu.ifpb.pweb2.hackaton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import br.edu.ifpb.pweb2.hackaton.service.CorridaService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CorridaService corridaService ;


    @GetMapping
    public ModelAndView getForm(ModelAndView model) {
        model.setViewName("auth/login");
        return model;
    }

    @PostMapping
    public ModelAndView doLogin(@RequestParam("username") String username, HttpSession session, ModelAndView model, RedirectAttributes redirectAttts) {
        session.setAttribute("usuario", username);
        model.setViewName("redirect:/corridas/lobby");
        return model;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView mav, HttpSession session) {
        session.invalidate();
        mav.setViewName("redirect:/auth");
        return mav;
    }

}

