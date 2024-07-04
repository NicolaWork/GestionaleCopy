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

import com.copy.copy_vesuviana.model.Cls;
import com.copy.copy_vesuviana.service.ClsService;

@Controller
@RequestMapping("/cls")
public class ClsController {

    private ClsService clsService;

    public ClsController(ClsService clsService){
        this.clsService = clsService;
    }

    @GetMapping("/new")
    public String newClsForm(Model model) {
        model.addAttribute("cls", new Cls());
        return "newcls";  // Questo dovrebbe corrispondere al nome del template
    }

    @PostMapping("/form")
    public String postclsForm(@ModelAttribute Cls cls) {
        clsService.saveCls(cls);        
        return "redirect:/home";
    }

    @PostMapping("/findall")
    @ResponseBody
    public List<Cls> allBnr(){
        return clsService.getAllCls();
    }

    @PostMapping("/find/{id}")
    @ResponseBody
    public Cls findCls(@PathVariable(name="id")Long id){
        return clsService.getClsById(id);
    }


}
