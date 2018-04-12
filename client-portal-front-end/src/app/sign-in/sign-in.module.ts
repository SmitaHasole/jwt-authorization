import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignInComponent } from './sign-in/sign-in.component';
import { RouterModule } from '@angular/router';
import { LoginComponent } from 'app/sign-in/login/login.component';
import { SignInRouter } from 'app/sign-in/sign-in-routes';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    RouterModule, SignInRouter,
    FormsModule
  ],
  declarations: [SignInComponent, LoginComponent],
  exports: [SignInComponent]
})
export class SignInModule { }
