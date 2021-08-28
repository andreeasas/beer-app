import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FavoriteBeerListComponent} from "./favorite-beer-list/favorite-beer-list.component";
import {BeerListComponent} from "./beer-list/beer-list.component";

const routes: Routes = [
  { path: 'reviews', component: FavoriteBeerListComponent },
  {path:'beers', component:BeerListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
