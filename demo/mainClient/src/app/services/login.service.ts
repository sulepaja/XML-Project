import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

import { Http, Response, Headers } from "@angular/http";
import { BehaviorSubject } from 'rxjs/BehaviorSubject';


import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpErrorResponse, HttpParams, HttpHeaders } from '@angular/common/http';
//import { RequestOptions } from '@angular/http';
//import { Router } from '@angular/router';

import { AuthServiceService } from './auth-service.service'
import { MyCustomHttp } from './my-custom-http';
@Injectable()
export class LoginService {
  auth: any;
  constructor(private http: Http, auth: AuthServiceService) {
    this.auth = auth;
  }

  loginUser(user: any) {
    var token = btoa(user.email + ':' + user.password);
    this.auth.setToken(token);
    let headers = new HttpHeaders();
    headers.append('Authorization', `Basic ${this.auth.getToken()}`);

    return this.http
      .get("http://localhost:8080/users/angularUser")
      .map((data: Response) => {
        //console.log(data);
        this.auth.setUser(data.json());//uzeti korisnika i staviti u local storage
      });

  }

  registerUser(user: any) {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    alert(JSON.stringify(user));
    return this.http.post('http://localhost:8080/public/user/create',
      JSON.stringify(user), { headers: headers }).map((data: Response) => data.json());
  }

  confirmRegistration(token: string) {
    return this.http.get('http://localhost:8080/public/registrationConfirm?token=' + token);
  }
}
