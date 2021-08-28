import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FavoriteBeerListComponent} from "./favorite-beer-list/favorite-beer-list.component";
import {BeerListComponent} from "./beer-list/beer-list.component";
import {BeerReviewFormComponent} from "./favorite-beer-form/beer-review-form.component";

const routes: Routes = [
  // {path: 'favorites', component: FavoriteBeerListComponent},
  {path: 'beers', component: BeerListComponent},
  {path: 'favorites', component: BeerReviewFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
