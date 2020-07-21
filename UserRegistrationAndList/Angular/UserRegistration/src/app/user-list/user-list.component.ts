import { Component, OnInit } from '@angular/core';
import {User} from '../models/user.model';
import {Router} from '@angular/router';
import {UserService} from '../user-form/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUsers()
      .subscribe( data => {
        this.users = data;
      });
  }

  deleteUser(user: User): void {
    this.userService.deleteUser(user)
      .subscribe( data => {
        this.users = this.users.filter(u => u !== user);
      });
  }

  updateUser(id: number, username: string){
    this.router.navigate(['update_user', username, id]);
  }

}
