
import { TokenStorage } from 'app/tokenStorage';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private token: TokenStorage) { }
    ngOnInit() {
    }
    logout() {
      this.token.signOut();
    }
}
