import { Component, OnInit } from '@angular/core';
import { AccountService } from '../../services/account.service';
import { Account } from '../../models/account';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-account-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.scss']
})
export class AccountListComponent implements OnInit {
  accounts: Account[] = [];

  constructor(private accountService: AccountService) {}

  ngOnInit(): void {
    this.accountService.getAllAccounts().subscribe(data => {
      this.accounts = data;
    });
  }
}
