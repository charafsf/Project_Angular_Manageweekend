import { SignupComponent } from './auth/signup/signup.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AgmCoreModule } from '@agm/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import {MatRadioModule} from '@angular/material/radio';
import { AppComponent } from './app.component';
import { MatMenuModule} from '@angular/material/menu';

import {
  MatFormFieldModule,
  MatSelectModule,
  MatInputModule,
  MatButtonModule,
  MatCardModule,
  MatTabsModule,
  MatGridListModule,
  MatIconModule,
  MatStepperModule,
  MatCheckboxModule,
  MatToolbarModule,
  MatTableModule,
} from '@angular/material/';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { HomeComponent } from './home/home.component';
import { HomePageComponent } from './homePage/homePage.component';
import { NavBarComponent } from './menu/nav-bar/nav-bar.component';
import { ConfigV2Component } from './configV2/config2.component';
import { ChooseComponent } from './configV2/choose/choose.component';
import { ConfSportComponent } from './configV2/confSport/confSport.component';
import { LoginComponent } from './auth/login/login.component';
import { MessageComponent } from './configV2/message/message.component';
import { ProfilComponent } from './configV2/profil/profil.component';
import { FavorisportComponent } from './configV2/favorisport/favorisport.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HomePageComponent,
    SignupComponent,
    NavBarComponent,
    ChooseComponent,
    ConfigV2Component,
    ConfSportComponent,
    ChooseComponent,
    MessageComponent,
    ProfilComponent,
    LoginComponent,
    FavorisportComponent,
  ],
  imports: [
    AgmCoreModule.forRoot({
      apiKey: ''
    }),
    MatTabsModule,
    MatGridListModule,
    BrowserModule,
    AppRoutingModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    MatIconModule,
    MatStepperModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatRadioModule,
    MatMenuModule,
    MatCheckboxModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
