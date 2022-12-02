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
    headers: new HttpHeaders({ 'Content-Type': 'application/pdf' })
  };


  getPapers(id: number): Observable<any> {
    console.log("Sending request");
    return this.http.get<Paper[]>(this.submitterUrl +"/"+ id+"/papers").pipe(
      catchError(this.handleError<Paper[]>('getpapers', []))
    );
  }
  uploadPapers(id:number,file: File): Observable<any> {
    console.log("Sending uplaod request"+id);
    console.log(file);

    const formData = new FormData(); 
        
    formData.append("file", file);


    return this.http.post<any>(this.submitterUrl +"/"+ id+"/addPaperFile",formData).pipe(
      catchError(this.handleError<any>('upload', []))
    );
  }
  downloadPapers(id:number): Observable<any> {
    console.log("Sending download request"+id);
     
    return this.http.get(this.submitterUrl +"/"+ id+"/downloadPaper",{responseType: "blob", headers: {'Accept': 'application/pdf'}}).pipe(
      catchError(this.handleError<any>('download', []))
    );
  }
  updatePaper(p:Paper): Observable<any>{
    return this.http.post<any>(this.submitterUrl +"/updatePaper",p).pipe(
      catchError(this.handleError<any>('upload', []))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error("asdasdasdas")
      console.error(error); // log to console instead
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };

    getId(){
      return <number><unknown>sessionStorage.getItem("userId");
    }

}

}
