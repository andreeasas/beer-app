import {Component, OnInit} from '@angular/core';
import {BeerDetails} from "../model/beer-details";
import {BeerService} from "../service/beer.service";
import {Observable, of, from} from 'rxjs';
import {BeerSearchCriteria} from "../model/beer-search-criteria";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {Beer} from "../model/beer";

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.css']
})
export class BeerListComponent implements OnInit {

  beerSearchCriteria: BeerSearchCriteria;

  currentIndex = -1;
  currentBeer: Beer;

  beers: Beer[];

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private beerService: BeerService) {
    this.beerSearchCriteria = new BeerSearchCriteria();
  }

  ngOnInit(): void {
    this.beerService.findAll().subscribe(data => {
      this.beers = data;
    });
  }

  setActiveBeer(beer: Beer, index: number): void {
    this.currentBeer = beer;
    this.currentIndex = index;
  }

  searchByCriteria() {
    this.beerService.findByCriteria(this.beerSearchCriteria).subscribe(data => {
      this.beers = data;
    });
  }

  saveFavorite() {
    this.router.navigate(['/favorites-add', this.currentBeer.id]);
  }
}
