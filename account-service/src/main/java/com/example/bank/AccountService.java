package com.example.bank;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

  private final AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public List<AccountDto> getAllAccounts() {
    return accountRepository.findAll().stream()
        .map(AccountDto::fromEntity)
        .collect(Collectors.toList());
  }

  public AccountDto createAccount(AccountDto dto) {
    Account account = new Account();
    account.setOwner(dto.getOwner());
    account.setBalance(dto.getBalance());
    account = accountRepository.save(account);
    return AccountDto.fromEntity(account);
  }

  public void transfer(TransferRequest request) {
    Account from = accountRepository.findById(request.getFromAccountId())
        .orElseThrow(() -> new RuntimeException("Senderkonto nicht gefunden"));
    Account to = accountRepository.findById(request.getToAccountId())
        .orElseThrow(() -> new RuntimeException("Empfängerkonto nicht gefunden"));

    if (from.getBalance() < request.getAmount()) {
      throw new RuntimeException("Nicht genügend Guthaben");
    }

    from.setBalance(from.getBalance() - request.getAmount());
    to.setBalance(to.getBalance() + request.getAmount());

    accountRepository.save(from);
    accountRepository.save(to);
  }
}
