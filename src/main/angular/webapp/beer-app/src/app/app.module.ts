import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { FavoriteBeerListComponent } from './favorite-beer-list/favorite-beer-list.component';
import { FavoriteBeerFormComponent } from './favorite-beer-form/favorite-beer-form.component';
import { FavoriteBeerService } from "./service/favorite-beer.service";
import { BeerListComponent } from './beer-list/beer-list.component';
import {NgxPaginationModule} from "ngx-pagination";
import { DisplayFieldErrorComponent } from './display-field-error/display-field-error.component';

@NgModule({
  declarations: [
    AppComponent,
    FavoriteBeerListComponent,
    FavoriteBeerFormComponent,
    BeerListComponent,
    DisplayFieldErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule
  ],
  providers: [FavoriteBeerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
