import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserFormComponent } from './user-form/user-form.component';
import {UserListComponent} from './user-list/user-list.component';
import {UpdateUserComponent} from './update-user/update-user.component';

const routes: Routes = [

  { path: 'user_list', component: UserListComponent},
  { path: 'add_user', component: UserFormComponent},
  { path: 'update_user/:username/:id', component: UpdateUserComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
