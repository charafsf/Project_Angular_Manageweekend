import { HomeComponent } from './home/home.component';
import { HomePageComponent } from './homePage/homePage.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './auth/signup/signup.component';
import { ConfigV2Component } from './configV2/config2.component';
import { ConfSportComponent } from './configV2/confSport/confSport.component';
import { LoginComponent } from './auth/login/login.component';
import { MessageComponent } from './configV2/message/message.component';
import { ProfilComponent } from './configV2/profil/profil.component';
import { FavorisportComponent } from './configV2/favorisport/favorisport.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'homePage', component: HomePageComponent },
  { path: 'confSport', component: ConfSportComponent },
  { path: 'favorisportComponent', component: FavorisportComponent},
  { path: '', component: LoginComponent},
  { path: 'message', component: MessageComponent},
  { path: 'profil', component: ProfilComponent},
  { path: 'favorisport', component: FavorisportComponent},
  { path: 'signup', component: SignupComponent}];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
