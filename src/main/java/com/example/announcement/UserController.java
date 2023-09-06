package com.example.announcement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnnouncementRepository announcementRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/loginold")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/loginold")
    public String loginUser(@ModelAttribute("user") User user) {
        // Add login handling logic here
        return "redirect:/dashboard";
    }

    @GetMapping("/announcement")
    public String showDashboard(Model model) {
        model.addAttribute("announcements", announcementRepository.findAll());
        return "/WEB-INF/views/dashboard.jsp";
    }

    @PostMapping("/announcement")
    public String sendAnnouncement(@RequestParam("announcement") String announcement) {
        Announcement newAnnouncement = new Announcement();
        newAnnouncement.setMessage(announcement);
        announcementRepository.save(newAnnouncement);
        return "redirect:/dashboard";
    }
}
