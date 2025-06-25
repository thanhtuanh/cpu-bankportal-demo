package com.example.bank;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    AccountRepository repo = mock(AccountRepository.class);
    AccountService service = new AccountService(repo);

    @Test
    void testGetAllAccounts() {
        Account acc = new Account(); acc.setOwner("Max"); acc.setBalance(100);
        when(repo.findAll()).thenReturn(Arrays.asList(acc));
        List<AccountDto> result = service.getAllAccounts();
        assertEquals(1, result.size());
        assertEquals("Max", result.get(0).getOwner());
    }

    @Test
    void testCreateAccount() {
        AccountDto dto = new AccountDto(); dto.setOwner("Anna"); dto.setBalance(200);
        Account acc = new Account(); acc.setOwner("Anna"); acc.setBalance(200);
        when(repo.save(any())).thenReturn(acc);
        AccountDto created = service.createAccount(dto);
        assertEquals("Anna", created.getOwner());
        assertEquals(200, created.getBalance());
    }

    @Test
    void testTransferThrowsIfAccountNotFound() {
        TransferRequest req = new TransferRequest();
        when(repo.findById(1L)).thenReturn(Optional.empty());
        Exception ex = assertThrows(RuntimeException.class, () -> service.transfer(req));
        assertTrue(ex.getMessage().contains("Senderkonto nicht gefunden"));
    }

    // Weitere Tests für „Nicht genügend Guthaben“ etc.
}