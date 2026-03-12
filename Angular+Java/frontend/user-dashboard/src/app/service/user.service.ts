import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from '../models/user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService 
{

  private baseUrl = 'http://localhost:8080/api/users';

  constructor(private http:HttpClient) { }

  getUsers()//:Observable<any>
  {
    return this.http.get<User[]>(this.baseUrl);
  }

  searchUsers(name:string)
  {
    return this.http.get<User[]>(`http://localhost:8080/api/users/search?name=${name}`);
  }
}
