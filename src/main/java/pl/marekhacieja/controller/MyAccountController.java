package pl.marekhacieja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.marekhacieja.service.OrderService;
import pl.marekhacieja.service.UserService;

@Controller
public class MyAccountController {
    private UserService userService;
    private OrderService orderService;

    @Autowired
    public MyAccountController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/users/{id}")
    public String referToMyAccount(Model model) {
        userService.addAttributeUser(getLoggedUserName(), model);
        orderService.addAttributeSum(model);
        return "account";
    }

    private String getLoggedUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

}

