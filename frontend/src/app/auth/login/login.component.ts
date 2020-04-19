import { Account } from '../account.model';
import { AuthService } from '../auth.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: 'login.component.html',
  styleUrls: ['login.component.scss']
})
export class LoginComponent implements OnInit {

  isLoading = false;
  form: FormGroup;

  constructor(private authService: AuthService) {}

  ngOnInit() {
    this.form = new FormGroup({
      login: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      }),
      password: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      })
    });
  }
  onLogin() {
    if (this.form.invalid) {
      return;
    } else {
      const account: Account = {
        login: this.form.value.login,
        password: this.form.value.password
      };
      this.authService.connecte(account);
    }
  }
}
