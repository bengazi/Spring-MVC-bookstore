package pl.marekhacieja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marekhacieja.service.AccountService;
import pl.marekhacieja.service.OrderService;
import pl.marekhacieja.service.UserService;

@RequestMapping(value = "/my-account")
@Controller
public class AccountController {
    private UserService userService;
    private OrderService orderService;
    private AccountService accountService;

    @Autowired
    public AccountController(UserService userService, OrderService orderService, AccountService accountService) {
        this.userService = userService;
        this.orderService = orderService;
        this.accountService = accountService;
    }

    @GetMapping("")
    public String referToMyAccount(Model model) {
        userService.addAttributeUser(model);
        orderService.addAttributeTotalValue(model);
        return "account/main";
    }

    // ### TODO ###

    @GetMapping("/information")
    public String referToAccountInformation(Model model) {
        orderService.addAttributeTotalValue(model);
        return "account/information";
    }

    @GetMapping("/change")
    public String referToAccountInformationChange(Model model) {
        orderService.addAttributeTotalValue(model);
        return "account/informationChange";
    }

    @GetMapping("/orders")
    public String referToMyOrders(Model model) {
        orderService.addAttributeTotalValue(model);
        accountService.addAttributeOrders(model);
        return "account/orders";
    }

    @GetMapping("/password")
    public String referToPasswordChange(Model model) {
        orderService.addAttributeTotalValue(model);
        return "account/passwordChange";
    }

}

