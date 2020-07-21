import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';




export class getUsers {

  constructor(
    public id: number,
    public username: string,
    public useremail: string,
    public userpassword: string
  ) { }
}

@Injectable({
  providedIn: 'root'
})

export class HttpClientService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getUser()
  {
    console.log('test call');
    return this.httpClient.get<getUsers[]>('http://localhost:8080/users/all');
  }
}


