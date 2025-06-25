import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-transfer',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './transfer.component.html'
})
export class TransferComponent {
  transferData = {
    fromAccountId: 0,
    toAccountId: 0,
    amount: 0
  };

  // ✅ Fehlende Property hinzufügen
  message: string = '';

  submitTransfer() {
    // Beispiel-Demo: Erfolgsmeldung setzen
    this.message = 'Transfer erfolgreich ausgeführt (Demo)';
  }
}
