import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { PatientData } from 'app/patient.data';
import { ClinicianData } from 'app/clinitian.data';
@Injectable()
export class UserService {

  private userUrl = 'http://localhost:8085/';
  constructor(private http: HttpClient, private client: Http) { }

  public getClinicianData(): Observable<ClinicianData> {
    return this.http.get<ClinicianData>(this.userUrl + 'clinician/1');
  }

  public getPatientData(): Observable<any> {
    return this.http.get<any>(this.userUrl + 'patient/2', { observe: 'response' });
  }

  public attemptAuth(ussername: string, password: string): Observable<any> {
    const credentials = { username: ussername, password: password };
    console.log('attempAuth ::');
    return this.http.post('http://localhost:8085/token/generate-token', credentials);
  }

  // public getPatientData(): Observable<any> {
  //   console.log('attempAuth ::');
  //   return this.http.get('/../assets/user.json');
  // }
}
