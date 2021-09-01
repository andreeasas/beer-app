import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FavoriteBeerListComponent} from "./favorite-beer-list/favorite-beer-list.component";
import {BeerListComponent} from "./beer-list/beer-list.component";
import {FavoriteBeerFormComponent} from "./favorite-beer-form/favorite-beer-form.component";

const routes: Routes = [
  {path: 'favorites-list', component: FavoriteBeerListComponent},
  {path: 'beers', component: BeerListComponent},
  {path: 'favorites-add/:beerId', component: FavoriteBeerFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
