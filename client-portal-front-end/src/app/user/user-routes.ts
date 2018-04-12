import { Route, RouterModule } from '@angular/router';
import { SignInComponent } from 'app/sign-in/sign-in/sign-in.component';
import { NgModule } from '@angular/core';
import { PatientViewComponent } from 'app/user/patient-view/patient-view.component';
import { ClinicianComponent } from 'app/user/clinician/clinician.component';
import { UserComponent } from 'app/user/user/user.component';


export const MODULE_ROUTES: Route[] =
    [{
        path: 'user', component: UserComponent,
        children: [
            {
                path: '',
                component: PatientViewComponent

            },
            {
                path: 'patient',
                component: PatientViewComponent

            },
            {
                path: 'clinician',
                component: ClinicianComponent
            }
        ]
    }];

    @NgModule({
        imports: [RouterModule.forChild(MODULE_ROUTES)],
        exports: [RouterModule]
    })
    export class UserRouter { }
