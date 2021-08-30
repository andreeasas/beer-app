import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BeerDetails} from "../model/beer-details";
import { Observable, of, Subject, Subscription, forkJoin } from 'rxjs';
import {BeerReview} from "../model/beer-review";
import {BeerSearchCriteria} from "../model/beer-search-criteria";
import {Beer} from "../model/beer";

@Injectable({
  providedIn: 'root'
})
export class BeerService {

  private readonly beersUrl: string;

  constructor(private http: HttpClient) {
    this.beersUrl = 'http://localhost:8080/api.beer.app/beers';
  }

  public findAll(): Observable<Beer[]> {
    return this.http.get<Beer[]>(this.beersUrl);
  }

  public findByCriteria(beerSearchCriteria: BeerSearchCriteria): Observable<Beer[]> {
    return this.http.post<Beer[]>(this.beersUrl, beerSearchCriteria);
  }

}
