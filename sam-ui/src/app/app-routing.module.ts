import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SubmittorPaperReviewComponent } from './submittor-paper-review/submittor-paper-review.component';
import { SubmittorPortalComponent } from './submittor-portal/submittor-portal.component';
import { SubmittorSubmitComponent } from './submittor-submit/submittor-submit.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'submitter/:id', component: SubmittorPortalComponent },
  { path: 'submitter/:id/submit', component: SubmittorSubmitComponent },
  { path: 'submitter/:id/review', component: SubmittorPaperReviewComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
