import { environment } from './../../../environments/environment';
import { Signup } from './signup.model';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SignUpService {

  constructor(private http: HttpClient, private router: Router) { }

  connecte(signup: Signup) {
    this.http.post<any>(environment.host + ':' + environment.port + '/api/signup', signup)
      .subscribe((responeMessage) => {
        console.log(responeMessage);
        this.router.navigate(['/homePage']);
      });
  }
}
