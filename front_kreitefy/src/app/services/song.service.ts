import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Song} from "../interfaces/Song";
import {AuthService} from "./auth.service";

@Injectable({
  providedIn: 'root'
})
export class SongService {
  private baseUrl: string = 'http://localhost:8080/api/v1/canciones/'

  constructor(private http: HttpClient, private authService: AuthService) { }

  public getNovedades():Observable<Song[]>{
    const token = this.authService.getToken();
    return this.http.get<Song[]>(this.baseUrl + "novedades", {headers:{ Authorization: `Bearer ${token}` }});
  }

  public getSong(id: number):Observable<Song>{
    const token = this.authService.getToken();
    return this.http.get<Song>(this.baseUrl + "cancion/" + id, {headers:{ Authorization: `Bearer ${token}` }});
  }

  public addReproduction(id: number):Observable<Song>{
    const token = this.authService.getToken();
    return this.http.get<Song>(this.baseUrl + "reproduction/" + id, {headers:{ Authorization: `Bearer ${token}` }});
  }

  public setStars(id: number, estrellas: number):Observable<Song>{
    const token = this.authService.getToken();
    return this.http.get<Song>(this.baseUrl + "stars/" + id + "/" + estrellas, {headers:{ Authorization: `Bearer ${token}` }});
  }

}
