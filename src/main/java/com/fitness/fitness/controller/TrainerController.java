package com.fitness.fitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.fitness.fitness.model.Trainer;
<<<<<<< HEAD
import com.fitness.fitness.service.TrainerService;
=======
import com.fitness.fitness.repository.TrainerRepo;
>>>>>>> 56a0767345033be674f69e8187e16f3e4d3bcebb
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class TrainerController {
    @Autowired
    private TrainerService trainerService;
    
    @GetMapping("/trainers/view")
    public ModelAndView view(Model model) {
        return new ModelAndView("trainers","trainers", trainerService.getAll());
    }
    
    
    @GetMapping("/view_trainers")
    public String viewTrainers(@RequestParam(value ="rank",required=false) Integer rank, Model model) {
        if (rank== null) {
            List<Trainer> trainers = trainerService.getAll();            model.addAttribute("trainers", trainers);
        } else{
            List<Trainer> filteredTrainers = trainerService.findAllByRank(rank.intValue());
            model.addAttribute("trainers", filteredTrainers);
    }
        return "trainers";
    }
    
    
    
    
    @GetMapping("/trainer_profile")
    public String TrainerProfile(@RequestParam(value ="id",required=false) Integer id, Model model) {
        Trainer trainer = trainerService.findById(id).orElse(null);
        model.addAttribute("trainer", trainer);
        return "trainerprofile";
    }


    
    // @GetMapping("book_appointment")
    // public String getMethodName(@RequestParam (value = "trainer.id", required=false)Integer trainerId, Model model) {
    //     return new String();
    // }
    
    
}
