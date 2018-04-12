import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AppRouting } from 'app/app.router';
import { SignInModule } from 'app/sign-in/sign-in.module';
import { UserModule } from 'app/user/user.module';
import { UserService } from 'app/user.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Ng2Webstorage } from 'ngx-webstorage';
import { TokenStorage } from 'app/tokenStorage';
import { Interceptor } from 'app/app.interceptor';
import { HttpModule } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRouting,
    SignInModule,
    UserModule,
    HttpClientModule, HttpModule,
    Ng2Webstorage
  ],
  providers: [UserService, TokenStorage, { provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
