import { Component, OnInit } from '@angular/core';
import {FavoriteBeer} from "../model/favorite-beer";
import {FavoriteBeerService} from "../service/favorite-beer.service";

@Component({
  selector: 'app-favorite-beer-list',
  templateUrl: './favorite-beer-list.component.html',
  styleUrls: ['./favorite-beer-list.component.css']
})
export class FavoriteBeerListComponent implements OnInit {

  favoriteBeers: FavoriteBeer[];

  constructor(private favoriteBeerService: FavoriteBeerService) { }

  ngOnInit(): void {
    this.favoriteBeerService.findAll().subscribe(data => {
      this.favoriteBeers = data;
    });
  }

}
