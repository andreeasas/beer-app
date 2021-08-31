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

  favoriteBeers: FavoriteBeerResponse[];
  userEmail: string;

  constructor(private favoriteBeerService: FavoriteBeerService) { }

  ngOnInit(): void {
  }

  onSearch() {
    this.favoriteBeerService.findByEmail(this.userEmail).subscribe(data => {
      console.log(data);
      this.favoriteBeers = data;
    });
  }
}
