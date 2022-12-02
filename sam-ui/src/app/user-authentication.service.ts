import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import AbstractUser from './AbstractUser';
import UserCredential from './UserCredential';

@Injectable({
  providedIn: 'root'
})
export class UserAuthenticationService {

  private serverUrl = "http://localhost:8080/"
  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  authenticate(u: UserCredential, userType: string): Observable<AbstractUser>{
    let url = this.serverUrl;
    if(userType == "submittor"){
      url+= 'submittor/'
    }

    url+='authenticate'


    return this.http.post<AbstractUser>(url, u, this.httpOptions).pipe(
      catchError(this.handleError<AbstractUser>('authenticate',undefined))
    );
  }

  private handleError<T>(operation = 'operation', result?: T){
    return (error: any): Observable<T>=>{
      console.log(error);
      return of(result as T);
    }
  }

}
