package org.iftm.poo.model.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-17T21:33:15.878-0300")
@StaticMetamodel(DebitoEmprestimo.class)
public class DebitoEmprestimo_ {
	public static volatile SingularAttribute<DebitoEmprestimo, Integer> codDebito;
	public static volatile SingularAttribute<DebitoEmprestimo, Date> data;
	public static volatile SingularAttribute<DebitoEmprestimo, BigDecimal> taxa;
	public static volatile SingularAttribute<DebitoEmprestimo, Emprestimo> emprestimo;
}
