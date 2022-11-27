import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SubmittorPortalComponent } from './submittor-portal/submittor-portal.component';
import { AdminPortalComponent } from './admin-portal/admin-portal.component';
import { PCCPortalComponent } from './pccportal/pccportal.component';
import { PCMPortalComponent } from './pcmportal/pcmportal.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    SubmittorPortalComponent,
    AdminPortalComponent,
    PCCPortalComponent,
    PCMPortalComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
