import { Component, OnInit, OnDestroy } from '@angular/core';
import { } from 'googlemaps';
import { Router, NavigationEnd } from '@angular/router';
import { Location } from '@angular/common';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {
  title = 'frontend';
  hideSideNav: boolean;
  path = ['', '/signup'];
  routerSub: Subscription;

  constructor(private router: Router, private location: Location) {

  }

  ngOnInit() {
    this.routerSub = this.router.events.subscribe(event => {
      if (this.path.includes(this.location.path())) {
        this.hideSideNav = true;
      } else {
        this.hideSideNav = false;
      }
    });
  }

  ngOnDestroy() {
    this.routerSub.unsubscribe();
  }
}
