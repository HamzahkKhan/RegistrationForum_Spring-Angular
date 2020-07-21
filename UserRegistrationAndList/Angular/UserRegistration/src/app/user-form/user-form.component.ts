import {Component, OnInit} from '@angular/core';

import { User } from '../models/user.model';
import {Router} from '@angular/router';
import {UserService} from './user.service';
import {AddUserUserInfo} from '../models/user_userinfo.model';


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  user: AddUserUserInfo = new AddUserUserInfo();


  username = '';
  password = '';
  email = '';
  dateOfBirth = '';
  address = '';
  nationlity = '';
  phonenumber = '';

  errorEmail = '';
  errorName = '';
  fixerror = '';


  enableAddButton = true;
  hide = true;


  constructor( private router: Router, private userService: UserService) {


  }

  createUser(): void {
    this.user.username = this.username;
    this.user.useremail = this.email;
    this.user.userpassword = this.password;
    this.user.address = this.address;
    this.user.dob = this.dateOfBirth;
    this.user.phonenumber = this.phonenumber;
    this.user.nationality = this.nationlity;

    if (this.errorName !== '' || this.errorEmail !== ''){
      this.fixerror = 'Fix the errors';
    }else {

      this.userService.addUser(this.user)
        .subscribe(data => {
          alert('User info successfully.');
        });

      this.enableAddButton = true;
      this.fixerror = '';
      this.errorEmail = '';
      this.errorName = '';
      this.username = '';
      this.password = '';
      this.email = '';
      this.address = '';
      this.phonenumber = '';
      this.nationlity = '';
      this.dateOfBirth = '';
    }
  }

  ngOnInit(): void {
  }


  checkFormEmpty() {

    if (this.username.trim() !== '' && this.email.trim() !== '' && this.password.trim() !== '') {

        this.enableAddButton = false;

    } else {
      this.enableAddButton = true;
    }
  }

  checkEmail() {
    if (!this.email.includes('@') && this.email !== '') {
      this.errorEmail = 'Enter Correct Email';
    } else {
      this.errorEmail = '';
    }
  }

  checkUserName() {
    if (this.username.includes(' ') && this.username !== '') {
      this.errorName = 'User Names Cannot Have White Spaces';
    } else {
      this.errorName = '';
    }
  }


}



