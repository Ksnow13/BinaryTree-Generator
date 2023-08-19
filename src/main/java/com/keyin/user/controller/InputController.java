package com.keyin.user.controller;

import com.keyin.tree.BinarySearchTree;
import com.keyin.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InputController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/enter-numbers")
    public String inputPage() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    public String processInput(@RequestParam("numbers") String numbersEntered, Model model) {

        BinarySearchTree bsTree = new BinarySearchTree();

        String[] numbersList = numbersEntered.split("\\s+");

        // inserting the numbers entered into the tree

        for (String number : numbersList) {
            int num = Integer.parseInt(number);
            bsTree.insert(num);
        }

        //  creating JSON format and saving input and tree to db

        String jsonFormatTree = bsTree.JsonFormat();
        User user = new User();
        user.setInput(numbersEntered);
        user.setTree(jsonFormatTree);
        userRepository.save(user);

        // putting the data in the model so the html can retrieve it

        model.addAttribute("jsonData", jsonFormatTree);
        return "process-numbers";
    }

    @GetMapping("/previous-trees")
    public String PreviousTrees(Model model) {

        // getting the all inputs from db & making list to for the json format of each tree

        List<User> userInputList = userRepository.findAll();
        List<String> jsonFormatTreeList = new ArrayList<>();

        // creating trees

        for (User userInput : userInputList) {

            BinarySearchTree bst = new BinarySearchTree();
            String[] numbersList = userInput.getInput().split("\\s+");

            for (String number : numbersList) {
                int num = Integer.parseInt(number);
                bst.insert(num);
            }

            String jsonFormatTree = bst.JsonFormat();
            jsonFormatTreeList.add(jsonFormatTree);

        }

        // putting the data in the model so the html can retrieve it

        model.addAttribute("jsonFormatTreeList", jsonFormatTreeList);
        return "previous-trees";
    }

}
