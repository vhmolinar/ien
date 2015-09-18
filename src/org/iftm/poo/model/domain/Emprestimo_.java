package org.iftm.poo.model.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-17T21:33:15.883-0300")
@StaticMetamodel(Emprestimo.class)
public class Emprestimo_ {
	public static volatile SingularAttribute<Emprestimo, Integer> codEmprestimo;
	public static volatile SingularAttribute<Emprestimo, Date> dataEmprestimo;
	public static volatile SingularAttribute<Emprestimo, Date> dataDevolucao;
	public static volatile ListAttribute<Emprestimo, ItemEmprestimo> itens;
	public static volatile ListAttribute<Emprestimo, DebitoEmprestimo> debitos;
	public static volatile SingularAttribute<Emprestimo, Usuario> usuario;
}
