package org.iftm.poo.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-17T21:33:15.900-0300")
@StaticMetamodel(Livro.class)
public class Livro_ {
	public static volatile SingularAttribute<Livro, Integer> codLivro;
	public static volatile SingularAttribute<Livro, String> nome;
	public static volatile SingularAttribute<Livro, String> edicao;
	public static volatile SingularAttribute<Livro, Integer> ano;
	public static volatile ListAttribute<Livro, ItemLivro> itens;
	public static volatile SingularAttribute<Livro, Categoria> categoria;
	public static volatile SingularAttribute<Livro, Autor> autor;
}
