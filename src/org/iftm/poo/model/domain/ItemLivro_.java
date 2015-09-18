package org.iftm.poo.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-17T21:33:15.893-0300")
@StaticMetamodel(ItemLivro.class)
public class ItemLivro_ {
	public static volatile SingularAttribute<ItemLivro, Integer> codItemLivro;
	public static volatile SingularAttribute<ItemLivro, Livro> livro;
	public static volatile SingularAttribute<ItemLivro, StatusLivro> statusLivro;
}
