package com.example.demo.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "horarios")
public class HorarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Date fecha;
    private Integer horas;
    private String profesor;
    
    @ManyToOne
    @JoinColumn(name="curso_id", nullable=false)
    private CursoModel curso;

    @ManyToOne
    @JoinColumn(name="salon_id", nullable=false)
    private SalonModel salon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }


    public CursoModel getCurso() {
        return curso;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }

    public SalonModel getSalon() {
        return salon;
    }

    public void setSalon(SalonModel salon) {
        this.salon = salon;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

}
