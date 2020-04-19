import { ActivatedRoute } from '@angular/router';
import { Component, OnInit, Output } from '@angular/core';
import { ConfSportService } from './confSport.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Conf } from './confsp.model';

@Component({
  selector: 'app-conf-sport',
  templateUrl: './confSport.component.html',
  styleUrls: ['./confSport.component.scss']
})

export class ConfSportComponent implements OnInit {

  form: FormGroup;

  constructor(private confSportService: ConfSportService) { }
  ngOnInit() {
    this.form = new FormGroup({
      firstName: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      }),
      lastName: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      }),
      email: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      }),
      password: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      }),
      adress: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      }),
      codePostal: new FormControl(null, {
        validators: [Validators.required, Validators.minLength(3)]
      })
  });
  }

  onSendInf()
  {
    if (this.form.invalid) {
      return;
    } else {
      const confsp: Conf = {
        firsName: this.form.value.firsName,
        lastName: this.form.value.lastName,
        password: this.form.value.password,
        email: this.form.value.email,
        adress: this.form.value.adress,
        codePostal: this.form.value.codePostal
      };
      this.confSportService.connecte(confsp);
    }
  }
}
