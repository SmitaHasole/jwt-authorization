import { Component, OnInit } from '@angular/core';
import { UserService } from 'app/user.service';

@Component({
  selector: 'app-clinician',
  templateUrl: './clinician.component.html',
  styleUrls: ['./clinician.component.css']
})
export class ClinicianComponent implements OnInit {

  constructor(private userService: UserService) {
}

ngOnInit() {
  this.call();
}

call() {
  this.userService.getClinicianData().subscribe(
    data => {
     console.log(data);
    }
  );
}
}
