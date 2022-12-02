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
import {MatCardModule} from '@angular/material/card';
import {CheckboxModule} from 'primeng/checkbox';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
import { NotificationComponent } from './notification/notification.component';
import { SubmittorSubmitComponent } from './submittor-submit/submittor-submit.component';
import { SubmittorPaperReviewComponent } from './submittor-paper-review/submittor-paper-review.component';
import {FileUploadModule} from 'primeng/fileupload';
import {HttpClientModule} from '@angular/common/http';
import { NavbarSubmittorComponent } from './navbar-submittor/navbar-submittor.component';
import {DropdownModule} from 'primeng/dropdown';
import { MessageComponent } from './message/message.component';
import {TieredMenuModule} from 'primeng/tieredmenu';
import {MenuItem} from 'primeng/api';
@NgModule({
  declarations: [
    AppComponent,
    SubmittorPortalComponent,
    AdminPortalComponent,
    PCCPortalComponent,
    PCMPortalComponent,
    LoginComponent,
    HomeComponent,
    NotificationComponent,
    SubmittorSubmitComponent,
    SubmittorPaperReviewComponent,
    NavbarSubmittorComponent,
    MessageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    CheckboxModule,
    ButtonModule,
    InputTextModule,
    FileUploadModule,
    HttpClientModule,
    DropdownModule,
    TieredMenuModule,
    

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
