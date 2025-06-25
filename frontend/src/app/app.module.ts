import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AccountListComponent } from './components/account-list/account-list.component';
import { TransferComponent } from './components/transfer/transfer.component';

@NgModule({
  declarations: [
    AppComponent,
    AccountListComponent,
    TransferComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
