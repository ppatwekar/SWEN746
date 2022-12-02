import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { map, Observable, of } from 'rxjs';
import { Paper } from './paper';
import { catchError, tap } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})

export class SubmitterService {
  
  private submitterUrl = 'http://localhost:8080/submittor';
  constructor(
    private http: HttpClient,
  ) { }
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };


  getPapers(id: number): Observable<any> {
    console.log("Sending request");
    return this.http.get<Paper[]>(this.submitterUrl +"/"+ id+"/papers").pipe(
      catchError(this.handleError<Paper[]>('getpapers', []))
    );
  }
  downloadPapers(id: number): Observable<any> {
    console.log("Sending request");
    return this.http.get<Paper[]>(this.submitterUrl +"/"+ id+"/papers").pipe(
      catchError(this.handleError<Paper[]>('getpapers', []))
    );
  }

  getId(){
    return <number><unknown>sessionStorage.getItem("userId");
  }



  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };

  

}

}
