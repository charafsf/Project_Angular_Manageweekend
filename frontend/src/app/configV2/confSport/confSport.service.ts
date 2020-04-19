import { environment } from '../../../environments/environment';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Conf } from './confsp.model';

@Injectable({
  providedIn: 'root',
})
export class ConfSportService {

  constructor(private http: HttpClient, private router: Router) { }

    connecte(confsp: Conf) {

  }
}
