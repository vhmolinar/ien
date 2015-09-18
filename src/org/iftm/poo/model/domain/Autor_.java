package org.iftm.poo.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-17T21:33:15.868-0300")
@StaticMetamodel(Autor.class)
public class Autor_ {
	public static volatile SingularAttribute<Autor, Integer> codAutor;
	public static volatile SingularAttribute<Autor, String> nome;
	public static volatile ListAttribute<Autor, Livro> livros;
}
