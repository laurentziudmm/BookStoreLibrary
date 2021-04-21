import { Component, OnInit } from '@angular/core';
import { InterfaceUtil } from '../core/interfaceUtil';
import { City } from '../home-page/city';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  cityInterface: City;

  constructor() { }

  getCity(): void {
    console.log(this.cityInterface);
  }

  ngOnInit(): void {
    this.cityInterface = InterfaceUtil.getEmptyCity();
  }
}
