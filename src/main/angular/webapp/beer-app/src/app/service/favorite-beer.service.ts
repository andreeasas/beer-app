import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FavoriteBeerResponse} from '../model/favorite-beer-response';
import {Observable} from 'rxjs';
import {BeerReview} from "../model/beer-review";

@Injectable({
  providedIn: 'root'
})
export class FavoriteBeerService {

  private readonly favoritesUrl: string;

  constructor(private http: HttpClient) {
    this.favoritesUrl = 'http://localhost:8080/api.beer.app/favorites';
  }

  public findByEmail(userEmail: string): Observable<FavoriteBeerResponse[]> {
    return this.http.get<FavoriteBeerResponse[]>(this.favoritesUrl+"/"+userEmail);
  }

  public save(beerReview: BeerReview) {
      return this.http.post<BeerReview>(this.favoritesUrl, beerReview);
  }
}
