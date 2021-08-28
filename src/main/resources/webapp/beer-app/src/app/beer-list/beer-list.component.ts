import { Component, OnInit } from '@angular/core';
import {BeerDetails} from "../model/beer-details";
import {BeerService} from "../service/beer.service";

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrls: ['./beer-list.component.css']
})
export class BeerListComponent implements OnInit {

  beerDetails: BeerDetails[];

  constructor(private beerService: BeerService) { }

  ngOnInit(): void {
    this.beerService.findAll().subscribe(data => {this.beerDetails=data});
  }

}
