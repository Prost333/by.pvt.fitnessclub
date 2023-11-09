package by.pvt.fitnesclub.controller;

import by.pvt.fitnesclub.dto.ActivitesRes;
import by.pvt.fitnesclub.entity.Activites;
import by.pvt.fitnesclub.service.imp.ActivitesServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("activites")
public class ActivitesMvcApi {
    @Autowired
    ActivitesServiceImp serviceImp;

    @ModelAttribute
    public void initAttributes(Model model) {
        model.addAttribute("activitesResponse", new Activites());
    }


    @PostMapping("/add")
    public ModelAndView addActivity(Activites activity, BindingResult bindingResult,Model model) {
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("addActivity");
        model.addAttribute("user", activity);
        var activRes=serviceImp.add(activity);
        modelAndView.addObject("activRes", activRes);
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView delete(Long id) {
        serviceImp.delete(serviceImp.findID(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/activities");
        return modelAndView;
    }

    @GetMapping("/getActiv")
    public ModelAndView getActivity(Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("activities/activities");
        var activityById = serviceImp.findID(id);
        modelAndView.addObject("activityResponse", activityById);
        return modelAndView;
    }
    @GetMapping("/getActivities")
    public ModelAndView getActivities() {
        var activities = serviceImp.getAll();
        ModelAndView modelAndView = new ModelAndView();
        ModelMap modelMap = new ModelMap();
        Map<String, Collection<Activites>> activitiesMap = new HashMap<>();
        activitiesMap.put("activities1", activities);
        modelMap.addAllAttributes(activitiesMap);
        modelAndView.addAllObjects(modelMap);
        modelAndView.setViewName("/activities");
        return modelAndView;
    }
}


