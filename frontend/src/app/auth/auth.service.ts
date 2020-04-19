import { Signup } from './signup/signup.model';
import { environment } from './../../environments/environment';
import { Account } from './account.model';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {

  constructor(private http: HttpClient, private router: Router) { }

  createAccount(signup: Signup) {
    this.http.post<any>(environment.host + ':' + environment.port + '/api/signup', signup)
      .subscribe((responeMessage) => {
        console.log(responeMessage);
        //this.router.navigate(['/homePage']);
      });
  }

  connecte(account: Account) {
    this.http.get(environment.host + ':' + environment.port + '/login/get?login=' + account.login)
      .subscribe((responeMessage: Account) => {
        console.log(responeMessage);
        if (responeMessage === null) {
          return;
        } else if (responeMessage.password === account.password) {
          this.router.navigate(['/home']);
        } else { console.log('Mot de passe différent'); }
      });
  }
}
