import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-view-recipe',
  templateUrl: './view-recipe.component.html',
  styleUrls: ['./view-recipe.component.css']
})
export class ViewRecipeComponent implements OnInit {
  id: String;
  constructor(
    private route: ActivatedRoute
  ) {
    console.log('Called Constructor');
    this.route.queryParams.subscribe(params => {
      this.id = params['param1'];
    });

  }


  ngOnInit(): void {}

}
