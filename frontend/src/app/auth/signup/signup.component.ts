import { AuthService } from './../auth.service';

import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Signup } from './signup.model';
import { SignUpService } from './signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: 'signup.component.html',
  styleUrls: ['signup.component.scss']
})
export class SignupComponent implements OnInit {

  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.firstFormGroup = new FormGroup({
      login: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      }),
      lastName: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      }),
      firstName: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      }),
      password: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      }),
      email: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      })
    });
    this.secondFormGroup = new FormGroup({
      sport: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      }),
      address: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      }),
      weather: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      })
    });
  }

  onRegister() {
    if (this.firstFormGroup.invalid  &&  this.firstFormGroup.invalid ) {
      return;
    } else {
      const signup: Signup = {
        login: this.firstFormGroup.value.login,
        lastName: this.firstFormGroup.value.lastName,
        firstName: this.firstFormGroup.value.firstName,
        email: this.firstFormGroup.value.email,
        password: this.firstFormGroup.value.password,
        sport: this.secondFormGroup.value.sport,
        adress: this.secondFormGroup.value.address,
        weather: this.secondFormGroup.value.weather,
      };
      this.authService.createAccount(signup);
    }
  }
}
