import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FavoriteBeer } from '../model/favorite-beer';
import { Observable, of, Subject, Subscription, forkJoin } from 'rxjs';
import {BeerReview} from "../model/beer-review";

@Injectable({
  providedIn: 'root'
})
export class FavoriteBeerService {

  private readonly favoritesUrl: string;

  constructor(private http: HttpClient) {
    this.favoritesUrl = 'http://localhost:8080/api.beer.app/favorites';
  }

  public findByEmail(userEmail: string): Observable<FavoriteBeer[]> {
    return this.http.get<FavoriteBeer[]>(this.favoritesUrl+"/"+userEmail);
  }

  public save(beerReview: BeerReview) {
    return this.http.post<BeerReview>(this.favoritesUrl, beerReview);
  }
}
