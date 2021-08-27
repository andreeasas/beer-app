import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FavoriteBeerListComponent } from './favorite-beer-list/favorite-beer-list.component';
import { FavoriteBeerFormComponent } from './favorite-beer-form/favorite-beer-form.component';
import {FavoriteBeerService} from "./service/favorite-beer.service";

@NgModule({
  declarations: [
    AppComponent,
    FavoriteBeerListComponent,
    FavoriteBeerFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [FavoriteBeerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
