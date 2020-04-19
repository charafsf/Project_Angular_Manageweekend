import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-choose',
  templateUrl: './choose.component.html',
  styleUrls: ['./choose.component.scss']
})

export class ChooseComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {

  }

  onClickConf() {
    this.router.navigateByUrl('/confSport');
  }
  onClickMessage() {
    this.router.navigateByUrl('/message');
  }
  onClickProfil() {
    this.router.navigateByUrl('/profil');
  }
  onClickdeconnect() {
    this.router.navigateByUrl('/');
  }
  onClickSport() {
    this.router.navigateByUrl('/favorisport');
  }

}
