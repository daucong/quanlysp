package ute.udn.vn.quanlysp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ute.udn.vn.quanlysp.entity.User;
import ute.udn.vn.quanlysp.service.UserService;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired private UserService userService;

    @GetMapping(value ={"quanlysp/", "/"})
    public String index(Model model) {
        List<User> users = userService.getAllUser();

        model.addAttribute("users", users);

        return "index";
    }

    @RequestMapping(value = "add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Long userId, Model model) {
        Optional<User> userEdit = userService.findUserById(userId);
        userEdit.ifPresent(user -> model.addAttribute("user", user));
        return "editUser";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(User user, RedirectAttributes ra) {
        userService.saveUser(user);
        ra.addFlashAttribute("message", "saved successfully.");
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Long userId, Model model) {
        userService.deleteUser(userId);
        return "redirect:/";
    }
}