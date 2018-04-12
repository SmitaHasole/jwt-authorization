import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user/user.component';
import { PatientViewComponent } from 'app/user/patient-view/patient-view.component';
import { ClinicianComponent } from 'app/user/clinician/clinician.component';
import { UserRouter } from 'app/user/user-routes';
import { RouterModule } from '@angular/router';
import { HeaderComponent } from 'app/user/header/header.component';
import { FooterComponent } from 'app/user/footer/footer.component';

@NgModule({
  imports: [
    CommonModule,
    UserRouter,
    RouterModule
  ],
  declarations: [
    PatientViewComponent,
    ClinicianComponent,
    UserComponent,
    HeaderComponent,
    FooterComponent
  ],
  exports: [UserComponent]
})
export class UserModule { }
