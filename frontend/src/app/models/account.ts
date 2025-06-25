// Modell eines Bankkontos
export interface Account {
  id?: number;          // optional, da bei Neuanlage noch nicht vorhanden
  owner: string;        // Kontoinhaber
  balance: string;      // Aktueller Kontostand
}
