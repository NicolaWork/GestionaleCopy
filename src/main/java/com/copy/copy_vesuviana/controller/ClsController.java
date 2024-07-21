package com.copy.copy_vesuviana.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.copy.copy_vesuviana.model.Cls;
import com.copy.copy_vesuviana.model.Fornitore;
import com.copy.copy_vesuviana.service.ClsService;
import com.copy.copy_vesuviana.service.FornitoreService;

@Controller
@RequestMapping("/cls")
public class ClsController {

    private ClsService clsService;

    @Autowired
    FornitoreService fornitoreService;

    public ClsController(ClsService clsService){
        this.clsService = clsService;
    }

    @GetMapping("/new")
    public String newClsForm(Model model) {
        List<Fornitore> listafornitori = fornitoreService.getAllFornitore();
        model.addAttribute("listafornitori", listafornitori );
        model.addAttribute("cls", new Cls());
        return "newcls";  // Questo dovrebbe corrispondere al nome del template
    }

    @PostMapping("/form")
    public String postclsForm(@ModelAttribute Cls cls) {
        clsService.saveCls(cls);        
        return "redirect:/home";
    }

    @GetMapping("/listacls")
    public String getListaCls(Model model){
        List<Cls> listacls = clsService.getAllCls();
        listacls.sort(Comparator.comparing(Cls::getId));
        model.addAttribute("listacls", listacls);
        return "listacls";
    }

    @PostMapping("/find/{id}")
    @ResponseBody
    public Cls findCls(@PathVariable(name="id")Long id){
        return clsService.getClsById(id);
    }


}
