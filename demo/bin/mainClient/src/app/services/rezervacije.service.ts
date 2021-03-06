import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { REZERVACIJE } from '../data/mock';
import { Rezervacija } from '../model/Rezervacija';
import { of } from 'rxjs/observable/of';


import {Http, Response, Headers } from "@angular/http";
import { HttpHeaders, HttpClient, HttpErrorResponse, HttpParams  } from '@angular/common/http';

import { BehaviorSubject } from 'rxjs/BehaviorSubject';

import 'rxjs/Rx'

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class RezervacijeService {

  constructor(private http: Http) { }

  getRezervacije(): Observable<Rezervacija[]> {
    return of(REZERVACIJE);
  }


  addReservation(reservationDTO : any) {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    // alert(JSON.stringify(reservationDTO));
    return this.http.post('http://localhost:8080/public/reservations/addReservation', 
      JSON.stringify(reservationDTO), { headers : headers }).map((data : Response) => data.json());
  }


}
