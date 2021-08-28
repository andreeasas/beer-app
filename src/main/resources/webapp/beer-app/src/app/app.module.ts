import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { FavoriteBeerListComponent } from './favorite-beer-list/favorite-beer-list.component';
import { BeerReviewFormComponent } from './favorite-beer-form/beer-review-form.component';
import { FavoriteBeerService } from "./service/favorite-beer.service";
import { BeerListComponent } from './beer-list/beer-list.component';
import {NgxPaginationModule} from "ngx-pagination";

@NgModule({
  declarations: [
    AppComponent,
    FavoriteBeerListComponent,
    BeerReviewFormComponent,
    BeerListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [FavoriteBeerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
