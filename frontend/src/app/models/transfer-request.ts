// Modell für Überweisungsanfragen
export interface TransferRequest {
  fromAccountId: number; // Quellkonto-ID
  toAccountId: number;   // Zielkonto-ID
  amount: number;        // Betrag in EUR
}
