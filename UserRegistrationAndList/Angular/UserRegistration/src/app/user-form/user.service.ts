import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';

import { User } from '../models/user.model';

import {Observable} from 'rxjs';
import {AddUserUserInfo} from '../models/user_userinfo.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {}

  private addUserUrl = 'http://localhost:8080/users/add';
  private getUserUrl = 'http://localhost:8080/users/all';
  private deleteUserUrl = 'http://localhost:8080/users'
  private updateUserUrl = 'http://localhost:8080/users/update';
  private getUserByIdUrl = 'http://localhost:8080/users/UserById';
  private getUserInfoByIdUrl = 'http://localhost:8080/users/UserInfoById';
  private addNewUser = 'http://localhost:8080/users/addnewUser ';

  public getUsers() {
    return this.http.get<User[]>(this.getUserUrl);
  }


  public createUser(user) {
   return this.http.post<User>(this.addUserUrl, user);
  }

  public addUser(user){

    return this.http.post<AddUserUserInfo>(this.addNewUser, user);

  }

  public deleteUser(user) {
    return this.http.delete(this.deleteUserUrl + '/' + user.id);
  }

  // tslint:disable-next-line:ban-types
  public updateUser(id: number, value: any): Observable<Object>{
    return this.http.put(`${this.updateUserUrl}/${id}`, value);
  }

  public getUserById(username: string, id: number): Observable<any>  {

    return this.http.get(`${this.getUserByIdUrl}/${username}/${id}`);
  }

  public getUserInfoById(id: number): Observable<any>  {

    return this.http.get(`${this.getUserInfoByIdUrl}/${id}`);
  }


}
