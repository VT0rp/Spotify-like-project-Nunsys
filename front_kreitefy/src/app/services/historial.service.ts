import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "./auth.service";
import {Historial} from "../interfaces/Historial";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HistorialService {
  private baseUrl: string = 'http://localhost:8080/api/v1/historial/'

  constructor(private http: HttpClient, private authService: AuthService) { }

  public createHistorial(historial:Historial):Observable<Historial>{
    const token = this.authService.getToken();
    return this.http.post<Historial>(this.baseUrl + "create", historial, {headers:{ Authorization: `Bearer ${token}`}});
  }
}
