import { Injectable } from '@angular/core';
import {User} from '../models/user.model';
import {BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserStoreService {

  private userSubject=new BehaviorSubject<User[]>([]);//creates a data container. Initial value = empty array.

  users$=this.userSubject.asObservable();//Components can subscribe to this...But they cannot directly modify it.=Good architecture.

  setUsers(users:User[])
  {
    this.userSubject.next(users);//.next() pushes new data into the store.All subscribers receive updates.
  }

  constructor() { }
}
