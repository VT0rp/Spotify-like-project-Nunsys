import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import {User} from "../../interfaces/User";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{

  user: User = {id: 0, username: '', firstName: '', lastName: '', email: '', password: '', role: ''};

  constructor(private router: Router, private authService: AuthService) {
  }

  ngOnInit() {
  }

  personaAction(form: NgForm){
    this.register();
  }

  cancel(){
    if (confirm('¿Estás seguro de que quieres cancelar?')) {
      console.log('Cancelado');
      this.router.navigateByUrl('/login');
    }
  }

  register(): void {
    this.authService.register(this.user).subscribe({
      next: (response) => {
        this.authService.saveToken(response.token);
        this.router.navigate(['/inicio']).then(()=>{
          window.location.reload();
        })
      },
      error: (error) => {
        console.error('There was an error!', error);
      }
    });
  }
}
