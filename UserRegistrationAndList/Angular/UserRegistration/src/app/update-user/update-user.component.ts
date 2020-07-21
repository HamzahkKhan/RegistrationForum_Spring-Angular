import { Component, OnInit } from '@angular/core';
import {User} from '../models/user.model';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../user-form/user.service';
import {UserInfo} from '../models/user_info.model';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {


  user: User;
  userInfo: UserInfo;
  id: number;
  uid;
  username = 'hamza';
  email = 'myemail';
  dateOfBirth = '11/11/11';
  address = 'my Adress';
  nationlity = 'PlaceHolder';
  phonenumber = '+00 0000 0000'

  errorName = '';
  enableAddButton = true;


  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.username = this.route.snapshot.params.username;
    this.userService.getUserById(this.username, this.id)
      .subscribe(data => {
        this.user = data;
        this.username = this.user.username;
        this.email = this.user.useremail;
      });

    this.userService.getUserInfoById(this.id)
      .subscribe(data => {
        this.userInfo = data;
        this.dateOfBirth = this.userInfo.dob;
        this.nationlity = this.userInfo.nationality;
        this.address = this.userInfo.address;
        this.phonenumber = this.userInfo.phonenumber;

    });
  }

  updateUser(): void {
    this.uid = this.userInfo.id;
    this.userInfo.phonenumber = this.phonenumber;
    this.userInfo.address = this.address;
    this.userInfo.nationality = this.nationlity;
    this.userInfo.dob = this.dateOfBirth;
    this.userService.updateUser(this.id, this.userInfo)
      .subscribe(data => {
        alert('User updated successfully.');
      });
  }

  checkUserName() {
    if (this.username.includes(' ') && this.username !== '') {
      this.errorName = 'User Names Cannot Have White Spaces';
    } else {
      this.errorName = '';
    }
  }

  checkFormEmpty() {

    if (this.username.trim() !== '') {

      this.enableAddButton = false;

    } else {
      this.enableAddButton = true;
    }
  }

}
