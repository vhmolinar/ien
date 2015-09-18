package org.iftm.poo.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-17T21:33:15.873-0300")
@StaticMetamodel(Categoria.class)
public class Categoria_ {
	public static volatile SingularAttribute<Categoria, Integer> codCategoria;
	public static volatile SingularAttribute<Categoria, String> descricao;
	public static volatile ListAttribute<Categoria, Livro> livros;
}
