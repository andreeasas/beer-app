import { Component, OnInit } from '@angular/core';
import {FavoriteBeerResponse} from "../model/favorite-beer-response";
import {FavoriteBeerService} from "../service/favorite-beer.service";
import {BeerDetails} from "../model/beer-details";

@Component({
  selector: 'app-favorite-beer-list',
  templateUrl: './favorite-beer-list.component.html',
  styleUrls: ['./favorite-beer-list.component.css']
})
export class FavoriteBeerListComponent implements OnInit {

  currentIndex = -1;
  currentFavorite: FavoriteBeerResponse;

  favoriteBeers: FavoriteBeerResponse[];
  userEmail: string;

  constructor(private favoriteBeerService: FavoriteBeerService) { }

  ngOnInit(): void {
    this.favoriteBeerService.findByEmail("joedoe@gmail.com").subscribe(data => {
      console.log(data.length);
      console.log(data.forEach(value => {console.log(value)}));
      this.favoriteBeers = data;

      console.log(this.favoriteBeers[0].jsonBeerDetails.name);
      console.log(this.favoriteBeers[0].jsonFavoriteBeer.userEmail);
    });
  }

  setActiveFavorite(favorite: FavoriteBeerResponse, index: number) {
    this.currentFavorite=favorite;
    this.currentIndex=index;
  }

  onSearch() {
    this.favoriteBeerService.findByEmail(this.userEmail).subscribe(data => {
      console.log(data);
      this.favoriteBeers = data;
    });
  }
}
