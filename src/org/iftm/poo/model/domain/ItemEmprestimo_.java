package org.iftm.poo.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-17T21:33:15.888-0300")
@StaticMetamodel(ItemEmprestimo.class)
public class ItemEmprestimo_ {
	public static volatile SingularAttribute<ItemEmprestimo, Integer> codItemEmprestimo;
	public static volatile SingularAttribute<ItemEmprestimo, ItemLivro> itemLivro;
	public static volatile SingularAttribute<ItemEmprestimo, Emprestimo> emprestimo;
}
