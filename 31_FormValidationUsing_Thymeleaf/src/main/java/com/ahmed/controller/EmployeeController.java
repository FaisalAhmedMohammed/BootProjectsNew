package com.ahmed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahmed.model.Employee;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    // 1️⃣ Load Form Page
    @GetMapping("/form")
    public String loadForm(Model model) {

        // Empty object for form binding
        model.addAttribute("employee", new Employee());

        return "index";   // index.html
    }

    // 2️⃣ Handle Form Submission
    @PostMapping("/register")
    public String submitForm(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult result,
            Model model) {

        // If validation errors → return to form
        if (result.hasErrors()) {
            return "index";
        }

        // Send object to success page
        model.addAttribute("employee", employee);

        return "view";   // view.html
    }
}
