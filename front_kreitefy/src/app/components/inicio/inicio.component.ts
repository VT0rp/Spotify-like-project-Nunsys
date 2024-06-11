import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Song} from "../../interfaces/Song";
import {SongService} from "../../services/song.service";

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit{

  canciones?: Song[];

  constructor(private router: Router, private songService: SongService) {
  }

  ngOnInit() {
  this.loadNovedades();
  }

  loadNovedades(){
    this.songService.getNovedades().subscribe({
      next: value => {
        this.canciones = value;
      },
      error: err => {
        console.error("Error al cargar las novedades", err)
      }
    })
  }

  goToFicha(id: number){
    this.router.navigateByUrl(`/ficha/${id}`);
  }

  protected readonly navigator = navigator;
}
