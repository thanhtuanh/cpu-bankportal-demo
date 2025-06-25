
package com.example.bank;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "*")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountDto> getAll() {
        return accountService.getAllAccounts();
    }

    @PostMapping
    public AccountDto create(@RequestBody AccountDto dto) {
        return accountService.createAccount(dto);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest request) {
        accountService.transfer(request);
    }
}
