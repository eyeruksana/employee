import { Injectable } from '@angular/core';
import { IEmployee } from './employee';
import { Http,Response} from '@angular/http';
import { Observable,throwError } from 'rxjs/';
import { HttpClient,HttpHeaders} from '@angular/common/http';
//import   'rxjs/add/operator/do';
//import "rxjs/Rx";


import { catchError, map ,retry} from 'rxjs/operators';
//import 'rxjs/add/operator/catch';

const url='http://localhost:9093/employee/empdata';
const url1='http://localhost:9093/employee/login';

@Injectable()
export class EmpService {
    constructor(private http:HttpClient){

    }

    login(username:string,password:string){
          const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
          return this.http.get(url1,{headers,responseType: 'text' as 'json'})
        }


    getEmployees():Observable<IEmployee[]>{
       
        return this.http.get<IEmployee[]>(url)
        .pipe(catchError(this.handleError));
        

       // return this.http.get(url);
        
    }

    /*private handleError(error: { statusText: String; }) {
        return Observable.(error.statusText);
    }*/

    handleError(error) {
        let errorMessage = '';
        if (error.error instanceof ErrorEvent) {
            // client-side error
            errorMessage = `Error: ${error.error.message}`;
        } else {
            // server-side error
            errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        console.log(errorMessage);
        return throwError(errorMessage);
    }

}