import { Component } from '@angular/core';
import { AccountListComponent } from './components/account-list/account-list.component';
import { TransferComponent } from './components/transfer/transfer.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [AccountListComponent, TransferComponent],
  templateUrl: './app.component.html'
})
export class AppComponent {
  title = 'bank-portal';
}
