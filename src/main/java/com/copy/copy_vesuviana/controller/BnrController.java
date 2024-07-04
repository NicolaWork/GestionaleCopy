package com.copy.copy_vesuviana.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.copy.copy_vesuviana.model.Bnr;
import com.copy.copy_vesuviana.service.BnrService;

@Controller
@RequestMapping("/bnr")
public class BnrController {

    private BnrService bnrService;

    public BnrController(BnrService bnrService){
        this.bnrService = bnrService;
    }

    @GetMapping("/new")
    public String newClienteForm(Model model) {
        model.addAttribute("bnr", new Bnr());
        return "newbnr";  // Questo dovrebbe corrispondere al nome del template
    }

    @PostMapping("/form")
    public String postBnrForm(@ModelAttribute Bnr bnr) {
        bnrService.saveBnr(bnr);        
        return "redirect:/home";
    }

    @PostMapping("/findall")
    @ResponseBody
    public List<Bnr> allBnr(){
        return bnrService.getAllBnr();
    }

    @PostMapping("/find/{id}")
    @ResponseBody
    public Bnr findBnr(@PathVariable(name="id")Long id){
        return bnrService.getBnrById(id);
    }

}
