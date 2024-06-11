package com.example.demo.domain.entity;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "HISTORIAL")
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private long idSong;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getIdSong() {
        return idSong;
    }

    public void setIdSong(long idSong) {
        this.idSong = idSong;
    }
}
