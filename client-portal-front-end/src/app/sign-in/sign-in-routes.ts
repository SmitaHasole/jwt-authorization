import { Route, RouterModule } from '@angular/router';
import {LoginComponent} from 'app/sign-in/login/login.component'
import { SignInComponent } from 'app/sign-in/sign-in/sign-in.component';
import { NgModule } from '@angular/core';

export const MODULE_ROUTES: Route[] =
    [{
        path: '', component: SignInComponent,
        children: [
            { path: '', redirectTo: 'login', pathMatch: 'full' },
            {
                path: 'login', component: LoginComponent
            }
        ]
    }];

    @NgModule({
        imports: [RouterModule.forChild(MODULE_ROUTES)],
        exports: [RouterModule]
    })
    export class SignInRouter { }
