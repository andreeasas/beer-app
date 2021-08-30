import { Component, OnInit } from '@angular/core';
import {FavoriteBeer} from "../model/favorite-beer";
import {FavoriteBeerService} from "../service/favorite-beer.service";
import {BeerDetails} from "../model/beer-details";

@Component({
  selector: 'app-favorite-beer-list',
  templateUrl: './favorite-beer-list.component.html',
  styleUrls: ['./favorite-beer-list.component.css']
})
export class FavoriteBeerListComponent implements OnInit {

  currentIndex = -1;
  currentFavorite: FavoriteBeer;

  favoriteBeers: FavoriteBeer[];
  userEmail: string;

  constructor(private favoriteBeerService: FavoriteBeerService) { }

  ngOnInit(): void {
    this.favoriteBeerService.findByEmail("joedoe@gmail.com").subscribe(data => {
      console.log(data);
      this.favoriteBeers = data;
    });
  }

  setActiveFavorite(favorite: FavoriteBeer, index: number) {
    this.currentFavorite=favorite;
    this.currentIndex=index;
  }

  changeUserEmail() {
    this.favoriteBeerService.findByEmail(this.userEmail).subscribe(data => {
      console.log(data);
      this.favoriteBeers = data;
    });
  }
}
