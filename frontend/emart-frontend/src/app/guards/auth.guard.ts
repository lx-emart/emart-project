import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {UserService} from "../services/user.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(
    private router: Router,
    private userService: UserService) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

      const currentUser = this.userService.currentUserValue;
      if (currentUser) {
        // authorised so return true
        return true;
      }

      console.log("Need log in");
      // not logged in so redirect to login page with the return url{queryParams: {returnUrl: state.url}}
      this.router.navigate(['/login']);
      return false;
  }

}
