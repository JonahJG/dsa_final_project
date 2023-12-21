package com.keyin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BTAController {

    private List<String> previousNumbers = new ArrayList<>();
    private final BTARepository btaRepository;
    private final BinarySearchTree bst = new BinarySearchTree(); // Single instance of BinarySearchTree

    @Autowired
    public BTAController(BTARepository btaRepository) {
        this.btaRepository = btaRepository;
    }

    private String accumulatedTreeJson = null;

    @GetMapping("/")
    public String showEnterNumbersPage(Model model) {
        model.addAttribute("previousNumbers", previousNumbers);
        return "enter_numbers";
    }

    @PostMapping("/")
    public String processNumbers(@RequestParam String numbers, Model model) {
        previousNumbers.add(numbers);

        String[] numberArray = numbers.split(",");
        List<NumberEntity> numberEntities = new ArrayList<>();

        for (String num : numberArray) {
            int intValue = Integer.parseInt(num.trim());

            NumberEntity numberEntity = new NumberEntity();
            numberEntity.setValue(intValue);
            numberEntities.add(numberEntity);
        }

        bst.resetRoot();

        bst.constructBST(numberEntities);

        if (accumulatedTreeJson == null) {
            accumulatedTreeJson = bst.getJsonRepresentation();
        } else {
            accumulatedTreeJson += "," + bst.getJsonRepresentation().substring(1);
        }

        NumberEntity combinedEntity = new NumberEntity();
        combinedEntity.setTreeJson("[" + accumulatedTreeJson + "]");
        btaRepository.save(combinedEntity);

        accumulatedTreeJson = null;

        return "redirect:/";
    }

    @GetMapping("/process-numbers")
    public String showProcessNumbersPage(Model model) {
        Optional<NumberEntity> lastEnteredNumber = btaRepository.findFirstByOrderByIdDesc();

        lastEnteredNumber.ifPresent(numberEntity -> model.addAttribute("lastEnteredNumber", numberEntity));

        return "process_numbers";
    }

    @GetMapping("/previous-trees")
    public String showPreviousTreesPage(Model model) {
        List<NumberEntity> allNumberEntities = btaRepository.findAll();

        List<String> treeJsonList = new ArrayList<>();
        for (NumberEntity entity : allNumberEntities) {
            treeJsonList.add(entity.getTreeJson());
        }

        model.addAttribute("treeJsonList", treeJsonList);

        return "previous_trees";
    }

}

//