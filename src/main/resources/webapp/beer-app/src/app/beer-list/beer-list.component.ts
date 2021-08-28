import {Component, OnInit} from '@angular/core';
import {BeerDetails} from "../model/beer-details";
import {BeerService} from "../service/beer.service";
import {Observable,of, from } from 'rxjs';

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.css']
})
export class BeerListComponent implements OnInit {

  currentIndex = -1;
  currentBeer: BeerDetails;

  beerDetails: BeerDetails[];
  selectedBeer?: BeerDetails;

  constructor(private beerService: BeerService) {
  }

  ngOnInit(): void {
    this.beerService.findAll().subscribe(data => {
      this.beerDetails = data
    });
  }

  onSelect(beer: BeerDetails): void {
    this.selectedBeer = beer;
  }

  setActiveBeer(beer:BeerDetails, index: number): void {
    this.currentBeer = beer;
    this.currentIndex = index;
  }

}
