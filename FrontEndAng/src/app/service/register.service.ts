import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Register } from '../register/register';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private backEndUrl: string;

  constructor(private http: HttpClient) {
    this.backEndUrl = 'http://localhost:8080/api/v1/users/register';
   }

  public registerUserFromRemote(register: Register): Observable<Register> {
    return this.http.post<Register>(this.backEndUrl, register);
  }
}

