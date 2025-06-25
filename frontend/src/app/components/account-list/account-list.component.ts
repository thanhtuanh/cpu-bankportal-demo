import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AccountService } from '../../services/account.service';
import { Account } from '../../models/account';

@Component({
  selector: 'app-account-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.scss']
})
export class AccountListComponent implements OnInit {
  accounts: Account[] = [];

  newOwner: string = '';
  newBalance: any = '';

  fromAccountId: any = '';
  toAccountId: any = '';
  amount: any = '';


  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
    this.loadAccounts();
  }

  loadAccounts() {
    this.accountService.getAllAccounts().subscribe(data => {
      this.accounts = data;
    });
  }

  createAccount() {
    const dto: Account = {
      owner: this.newOwner,
      balance: this.newBalance.toString()
    };

    this.accountService.createAccount(dto).subscribe(() => {
      this.newOwner = '';
      this.newBalance = ''; // vorher: 0
      this.loadAccounts();
    });
  }

  transfer() {
    const dto = {
      fromAccountId: Number(this.fromAccountId),
      toAccountId: Number(this.toAccountId),
      amount: Number(this.amount)
    };

    this.accountService.transferMoney(dto).subscribe(() => {
      this.fromAccountId = '';
      this.toAccountId = '';
      this.amount = '';
      this.loadAccounts();
    });
  }
}
