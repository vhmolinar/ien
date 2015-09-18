package org.iftm.poo.model.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-17T21:33:15.913-0300")
@StaticMetamodel(Reserva.class)
public class Reserva_ {
	public static volatile SingularAttribute<Reserva, Integer> codReserva;
	public static volatile SingularAttribute<Reserva, ItemLivro> itemLivro;
	public static volatile SingularAttribute<Reserva, Usuario> usuario;
}
