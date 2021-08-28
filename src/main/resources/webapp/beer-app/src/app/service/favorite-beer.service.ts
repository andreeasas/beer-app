import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FavoriteBeer } from '../model/favorite-beer';
import { Observable, of, Subject, Subscription, forkJoin } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FavoriteBeerService {

  private readonly favoritesUrl: string;

  constructor(private http: HttpClient) {
    this.favoritesUrl = 'http://localhost:8080/api.beer.app/favorites';
  }

  public findAll(): Observable<FavoriteBeer[]> {
    return this.http.get<FavoriteBeer[]>(this.favoritesUrl);
  }

  public save(favoriteBeer: FavoriteBeer) {
    return this.http.post<FavoriteBeer>(this.favoritesUrl, favoriteBeer);
  }
}