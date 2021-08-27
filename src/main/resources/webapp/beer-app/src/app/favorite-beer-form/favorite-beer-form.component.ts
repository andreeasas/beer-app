import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {FavoriteBeerService} from "../service/favorite-beer.service";
import {FavoriteBeer} from "../model/favorite-beer";

@Component({
  selector: 'app-favorite-beer-form',
  templateUrl: './favorite-beer-form.component.html',
  styleUrls: ['./favorite-beer-form.component.css']
})
export class FavoriteBeerFormComponent implements OnInit {

  // favoriteBeer: FavoriteBeer;
  //
  // constructor(  private route: ActivatedRoute,
  //               private router: Router,
  //               private favoriteBeerService: FavoriteBeerService) {
  //   this.favoriteBeer = new FavoriteBeer();
  // }
  //
  // onSubmit() {
  //   this.favoriteBeerService.save(this.favoriteBeer).subscribe(result => this.gotoUserList());
  // }
  //
  // gotoUserList() {
  //   this.router.navigate(['/users']);
  // }

  ngOnInit(): void {
  }

}
