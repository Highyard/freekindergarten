package com.example.demo.controller;

import com.example.demo.model.Child;
import com.example.demo.model.SystemUser;
import com.example.demo.services.SystemUserServiceImpl;
import com.example.demo.services.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SystemUserServiceImpl systemUserService;

    @Autowired
    UserServiceImpl userService;




    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("systemUser", new SystemUser());
        return "login";
    }




    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(@ModelAttribute SystemUser user, Model model){

        user = systemUserService.getUser(user.getUserName(), user.getPassword());
        if (user != null){
            return "redirect:/home";
        }

        model.addAttribute("error", true);
        model.addAttribute("logout", true);

        return "/login";
    }



    @GetMapping("/home")
    public String startside(Model model){
        log.info("Home action called");

        model.addAttribute("children", userService.fetchAllChildren());
        log.info("Home action ended");
        return "home";
    }

    @GetMapping("/create")
    public String opret(Model model){
        log.info("create action called");

        model.addAttribute("child", new Child());

        return "/create";
    }

    @PostMapping("/create")
    public String opret(@ModelAttribute Child child){
        log.info("create post action called");

        String index = Integer.toString(userService.fetchAllChildren().size());

        child.setId(Integer.parseInt(index));

        userService.addBarn(child);

        return "redirect:/home";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {

        log.info("delete  action called...");


        model.addAttribute("child", userService.fetchAllChildren().get(id));

        model.addAttribute("children", userService.fetchAllChildren());


        return "delete";
    }


    @PostMapping("/delete")
    public String delete(@ModelAttribute Child child, Model model) {

        log.info("delete post action called...");

        int id = child.getId();

        userService.fetchAllChildren().remove(child.getId());

        leftShiftId(userService.fetchAllChildren(), id);

        model.addAttribute("students", userService.fetchAllChildren());






        return "redirect:/home";

    }


    private void leftShiftId(ArrayList<Child> list, int id) {

        log.info("leftshift method called...");

        for (int i = id; i < list.size(); i++) {

            Child child = list.get(i);

            child.setId(child.getId() - 1);
        }
    }



    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {


        log.info("edit action called...");


        model.addAttribute("child", userService.fetchAllChildren().get(id));

        model.addAttribute("children", userService.fetchAllChildren());


        return "edit";
    }




    @PostMapping("/edit")
    public String edit(@ModelAttribute Child child, Model model) {


        log.info("edit post action called...");

        int id = child.getId();


        for (int i = 0; i < userService.fetchAllChildren().size(); i++) {

            if (id == userService.fetchAllChildren().get(i).getId()) {

                userService.fetchAllChildren().set(i, child);
                //students.remove(i);
                //students.add(i, student);
                break;
            }
        }


        model.addAttribute("students", userService.fetchAllChildren());

        return "redirect:/home";
    }








}
