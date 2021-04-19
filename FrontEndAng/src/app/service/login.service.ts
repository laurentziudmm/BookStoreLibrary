import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../login/login';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private backEndUrl: string;

  constructor(private http: HttpClient) {
    this.backEndUrl = 'http://localhost:8080/api/v1/users/login';
   }

  public loginUserFromRemote(login: Login): Observable<Login> {
   return this.http.post<Login>(this.backEndUrl, login);
  }
}

