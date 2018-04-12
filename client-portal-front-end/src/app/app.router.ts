
import { Route, RouterModule } from '@angular/router';

import { NgModule } from '@angular/core';

export const MODULE_ROUTES: Route[] = [{
    path: 'sign',
    loadChildren: './sign-in/sign-in.module#SignInModule',
},
{
    path: 'users',
    loadChildren: './user/user.module#UserModule',
}]

@NgModule({
    imports: [RouterModule.forRoot(MODULE_ROUTES, { useHash: true })],
    exports: [RouterModule]
})
export class AppRouting {
}
