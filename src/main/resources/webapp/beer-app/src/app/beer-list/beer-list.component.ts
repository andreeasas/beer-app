import {Component, OnInit} from '@angular/core';
import {BeerDetails} from "../model/beer-details";
import {BeerService} from "../service/beer.service";
import {Observable, of, from} from 'rxjs';
import {BeerSearchCriteria} from "../model/beer-search-criteria";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.css']
})
export class BeerListComponent implements OnInit {

  beerSearchCriteria: BeerSearchCriteria;

  currentIndex = -1;
  currentBeer: BeerDetails;

  beerDetails: BeerDetails[];
  selectedBeer?: BeerDetails;

  constructor(private formBuilder: FormBuilder,
              private beerService: BeerService) {
    this.beerSearchCriteria = new BeerSearchCriteria();
  }

  ngOnInit(): void {
    this.beerService.findAll().subscribe(data => {
      this.beerDetails = data;
    });
  }

  onSelect(beer: BeerDetails): void {
    this.selectedBeer = beer;
  }

  setActiveBeer(beer: BeerDetails, index: number): void {
    this.currentBeer = beer;
    this.currentIndex = index;
  }

  searchByCriteria() {
    this.beerService.findByCriteria(this.beerSearchCriteria).subscribe(data => {
      this.beerDetails = data;
    });
  }
}
