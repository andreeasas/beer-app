import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FavoriteBeerListComponent} from "./favorite-beer-list/favorite-beer-list.component";

const routes: Routes = [{ path: 'reviews', component: FavoriteBeerListComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
