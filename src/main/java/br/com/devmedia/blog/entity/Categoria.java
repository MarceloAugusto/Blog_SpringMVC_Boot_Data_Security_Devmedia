package br.com.devmedia.blog.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "categoria")
public class Categoria extends AbstractPersistable<Long> {

	@Column(nullable = false, unique = true, length = 30)
	private String descricao;
	
	@Column(nullable = false, unique = true, length = 30)
	private String permalink;
	
	@ManyToMany
	@JoinTable(
	name = "postagens_has_categorias", 
	joinColumns = @JoinColumn(name = "categoria_id"),
	inverseJoinColumns = @JoinColumn(name = "postagem_id")
	)
	private List<Postagem> postagens;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	
}
