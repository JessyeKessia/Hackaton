package br.edu.ifpb.pweb2.hackaton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.hackaton.model.Corrida;
import br.edu.ifpb.pweb2.hackaton.model.Pergunta;
import br.edu.ifpb.pweb2.hackaton.service.CorridaService;
import br.edu.ifpb.pweb2.hackaton.service.PerguntaService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/corridas")
public class ControllerCorrida {

    @Autowired
    private CorridaService corridaService;

    @Autowired
    private PerguntaService perguntaService;

    @ModelAttribute("perguntasItens")
    public List<Pergunta> getPerguntas() {
        return perguntaService.findAll();
    }

    @GetMapping("/lobby")
    public ModelAndView getForm(ModelAndView model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            model.setViewName("redirect:/auth");
            return model;
        }

        model.setViewName("corrida/lobby");
        List<Corrida> corridas = this.corridaService.findAll();
        System.out.println(corridas);
        model.addObject("corridas", corridas);
        return model;
    }

    @GetMapping("/{id}")
    public ModelAndView showCorrida(@PathVariable("id") Long id,
            HttpSession session,
            ModelAndView model) {
        Corrida corrida = this.corridaService.findById(id);
        if (corrida == null) {
            model.setViewName("redirect:/corridas/lobby");
            return model;
        }
        System.out.println(corrida.getPerguntas());
        model.addObject("corrida", corrida);
        model.setViewName("corrida/form");
        return model;
    }

    @PostMapping("/save")
    public ModelAndView save(Corrida corrida, ModelAndView model, RedirectAttributes redirectAttts) {
        corridaService.save(corrida);
        redirectAttts.addFlashAttribute("mensagem", "Corrida salva com sucesso!");
        model.setViewName("redirect:/corridas/form");
        return model;
    }

}
