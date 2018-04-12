import { Component, OnInit } from '@angular/core';
import { UserService } from 'app/user.service';
import { PatientData } from 'app/patient.data';


@Component({
  selector: 'app-patient-view',
  templateUrl: './patient-view.component.html',
  styleUrls: ['./patient-view.component.css']
})
export class PatientViewComponent implements OnInit {

  patientData: PatientData;
  data: any;
  constructor(private user: UserService) { }

  ngOnInit() {
    this.user.getPatientData().subscribe(data => {
      this.patientData = data.body;
      // console.log('data:' + this.patientData[0].paymentDone, this.patientData[0].reportReady);
      // console.log('data:' + this.patientData[1].paymentDone, this.patientData[1].reportReady);
    });
  }

}
