package br.com.devmedia.blog.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="contarios")
public class Comentario extends AbstractPersistable<Long> implements Comparable<Comentario>{
	

	@Column(nullable=false, columnDefinition="TEXT")
	private String texto;
	
	@DateTimeFormat(iso = ISO.DATE_TIME, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(name="data_comentario")
	private LocalDateTime dataComentario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Postagem postagem;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(LocalDateTime dataComentario) {
		this.dataComentario = dataComentario;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	protected void setId(Long id) {
		super.setId(id);
	}

	public int compareTo(Comentario comentario) {
		
		//return this.dataComentario.compareTo(comentario.getDataComentario());
		return comentario.getDataComentario().compareTo(this.dataComentario);
	}
	
	
}
