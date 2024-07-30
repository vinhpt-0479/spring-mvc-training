package com.example.handing_user_input;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerHandler {
    @GetMapping("/")
    public String index() {
        return "getForm"; // Trang sẽ được trả về
    }

    @GetMapping("/postform")
    public String getPostForm() {
        return "postform"; // Trang sẽ được trả về
    }

    @GetMapping("/search")
    public String search(
            @RequestParam(name = "name1", required = false) String name,
            @RequestParam(name = "address1", required = false) String address, Model model
    ) {
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        return "getdisplay";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "address", required = false) String address, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        return "postdisplay";
    }
}
