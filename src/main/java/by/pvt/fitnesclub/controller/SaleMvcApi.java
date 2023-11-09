package by.pvt.fitnesclub.controller;

import by.pvt.fitnesclub.entity.Sale;
import by.pvt.fitnesclub.service.imp.SaleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("sale")
public class SaleMvcApi {
    @Autowired
    SaleServiceImp saleServiceImp;

    @ModelAttribute
    public void initAttributes(Model model) {

        model.addAttribute("saleResponse", new Sale());
    }

    //    @PostMapping("/add")
    @GetMapping("/add")
    public ModelAndView add(Sale sale, BindingResult result, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sale");
        if (result.hasErrors()) {
            modelAndView.addObject("error", result.getAllErrors().get(0));
            modelAndView.setViewName("error");
            return modelAndView;
        }
        model.addAttribute("sale", sale);
        var saleRes = saleServiceImp.add(sale);
        modelAndView.addObject("saleResponse", saleRes);
        return modelAndView;
    }




}
