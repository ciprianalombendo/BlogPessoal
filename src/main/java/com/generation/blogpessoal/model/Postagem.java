package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // create table
@Table(name = "tb_postagens") // tb_postagens
public class Postagem {
	
	@Id // primary key  (id)
	@GeneratedValue (strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Long id ;
	
	@NotBlank(message = "O atributo é obrigatório!")
    @Size(min = 5, max = 100, message = "O atributo titulo deve conter no minimo 5 e no máximo 100")
	private String titulo;
	
	@NotNull(message = "O atributo texto é obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no minimo 10 e no máximo 1000")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	/**
	 * 
	 * Os Métodos Get e Set obrigatoriamente devem ser criados para todos os atributos
     * da Classe, inclusive os novos atributos que forem adicionados no decorrer do
     * processo de Desenvolvimento.
	 * 
	 */	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	/**
	 * Métodos Get e Set para o atributo tema
	 */
	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
}
