import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BeerDetails} from "../model/beer-details";
import { Observable, of, Subject, Subscription, forkJoin } from 'rxjs';
import {BeerReview} from "../model/beer-review";
import {BeerSearchCriteria} from "../model/beer-search-criteria";

@Injectable({
  providedIn: 'root'
})
export class BeerService {

  private readonly favoritesUrl: string;

  constructor(private http: HttpClient) {
    this.favoritesUrl = 'http://localhost:8080/api.beer.app/beers';
  }

  public findAll(): Observable<BeerDetails[]> {
    return this.http.get<BeerDetails[]>(this.favoritesUrl);
  }

  public findByCriteria(beerSearchCriteria: BeerSearchCriteria): Observable<BeerDetails[]> {
    return this.http.post<BeerDetails[]>(this.favoritesUrl, beerSearchCriteria);
  }

}
