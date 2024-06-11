import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit{
  username: string = '';
  valid?: boolean;

  constructor(private authService: AuthService, private router: Router, private http: HttpClient) {
  }

  ngOnInit() {
    if(this.tokenExists()){
      const token = this.authService.getToken();
      this.http.get<any>('http://localhost:8080/api/v1/user', {
        headers: { Authorization: `Bearer ${token}` }
      }).subscribe({
        next: (value) => {
          this.username = value.username;
          localStorage.setItem('username', value.username);
          this.authService.isTokenValid(this.username).subscribe({
            next: value => {
              this.valid = value;
            }
          })
        },
        error: (error) => {
          console.error('Error fetching username', error);
        }
      });
    }
  }


  tokenExists(){
    return this.authService.getToken() != null;
  }

  logIn(){
    this.router.navigateByUrl("/login");
  }
  logOut(){
    localStorage.removeItem('auth_token');
    localStorage.removeItem('username');
    this.router.navigateByUrl("/inicio").then(() => window.location.reload());
  }
}
