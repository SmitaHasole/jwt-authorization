import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import 'rxjs/add/operator/do';
import { TokenStorage } from 'app/tokenStorage';
import { HttpInterceptor, HttpHandler, HttpRequest, HttpUserEvent, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';



const TOKEN_HEADER_KEY = 'Authorization';


@Injectable()
export class Interceptor implements HttpInterceptor {
    headers: any;
    updatedToken;
    constructor(private token: TokenStorage, private router: Router) { }

    intercept(req: HttpRequest<any>, next: HttpHandler):
        Observable<HttpUserEvent<any>> {
        let token = this.token.getToken();
        if (token != null) {
            req = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token) });

            console.log('m in req header', req);
        }
        return next.handle(req).do((event: any) => {
            if (event instanceof HttpResponse) {
                this.updatedToken = event.headers.get('jwt');
                console.log('m in response header', this.updatedToken );
                this.token.saveToken(this.updatedToken);
                console.log('m in response header token which is stored', this.token.getToken());
            }
        }, (err: any) => {
            if (err instanceof HttpErrorResponse) {
                console.log('m in response header', err, err.headers.get('jwt'));
                if (err.status === 401) {
                    this.router.navigate(['login']);
                }
            }
        });
    }
}
