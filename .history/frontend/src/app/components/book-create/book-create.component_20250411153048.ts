import { Component, OnInit } from '@angular/core';
import { RouterModule, Router } from '@angular/router';
import { BookService } from '../../services/book.service';
import { Book } from '../../models/book.model';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-book-create',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './book-create.component.html',
  styleUrls: ['./book-create.component.css']
})
export class BookCreateComponent implements OnInit {
  book: Book = {
    id: 0,
    title: '',
    author: '',
    isbn: '',
    description: '',
    publicationDate: '',
    price: 0,
    pages: 0,
    genre: '',
    inStock: true
  };

  constructor(
    private readonly bookService: BookService,
    private readonly router: Router,
    private readonly authService: AuthService
  ) { }

  ngOnInit(): void {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/login']);
    }
  }

  createBook(form: NgForm): void {
    if (form.invalid) {
      console.warn('❌ Formular ist ungültig');
      return;
    }

    // Erstelle eine Kopie des Buches ohne die ID
    const bookToSave = { ...this.book };
    delete bookToSave.id; // ID entfernen, damit die Datenbank sie automatisch generiert

    this.bookService.createBook(bookToSave).subscribe({
      next: () => this.router.navigate(['/books']),
      error: err => console.error('❌ Fehler beim Speichern:', err)
    });
  }
}
