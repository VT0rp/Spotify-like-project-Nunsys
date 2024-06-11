import {Component, OnInit} from '@angular/core';
import {SongService} from "../../services/song.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Song} from "../../interfaces/Song";
import {faPlay} from "@fortawesome/free-solid-svg-icons";
import {Historial} from "../../interfaces/Historial";
import {HistorialService} from "../../services/historial.service";

@Component({
  selector: 'app-ficha',
  templateUrl: './ficha.component.html',
  styleUrls: ['./ficha.component.css']
})
export class FichaComponent implements OnInit{
  song?: Song;
  fechaFormateada?: string;

  constructor(private songService: SongService, private router: Router, private ar: ActivatedRoute, private hService: HistorialService) {
  }

  ngOnInit() {
    this.loadSong();
  }

  addReproduction(){
    if(this.song){
      this.createHistorial();
      this.songService.addReproduction(this.song.id).subscribe({
        next: value => {
          this.song = value;
        },
        error: err => {
          console.error("Error al añadir reproducción", err);
        }
      })
    }
  }

  getFecha(){
    let fecha = new Date();
    let dia = fecha.getDate();
    let mes = fecha.getMonth() + 1;
    let año = fecha.getFullYear();
     this.fechaFormateada = año + '-' + (mes < 10 ? '0' + mes : mes) + '-' + (dia < 10 ? '0' + dia : dia);
  }

  createHistorial(){
    this.getFecha();
    let username = localStorage.getItem('username');
    if(username != null && this.song && this.fechaFormateada){
      let historial: Historial = {fecha: this.fechaFormateada, username:username, idSong: this.song?.id}
      this.hService.createHistorial(historial).subscribe({
        error: err => {
          console.error("Error al guardar el historial", err);
        }
      })
    }
  }


  setStars(value: any){
    if(this.song){
      let stars: number = value.target.value;
      this.songService.setStars(this.song.id, stars).subscribe({
        next: value => {
          this.song = value;
        },
        error: err => {
          console.error("Error al asignar la valoración", err);
        }
      })
    }
  }


  loadSong(){
    const id: number = this.ar.snapshot.params["id"];
    this.songService.getSong(id).subscribe({
      next: value => {
        this.song = value;
      },
      error: err => {
        console.error("Error al cargar la canción", err);
      }
    });
  }

  protected readonly faPlay = faPlay;
}
