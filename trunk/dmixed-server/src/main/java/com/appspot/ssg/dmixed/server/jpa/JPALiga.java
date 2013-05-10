package com.appspot.ssg.dmixed.server.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;

@Entity
@Table(name = "liga")
@NamedQueries(@NamedQuery(name = JPALiga.ALLE_LIGEN, query = "SELECT liga FROM JPALiga liga"))
public class JPALiga {

    public static final String ALLE_LIGEN = "ALLE_LIGEN";

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String bezeichnung;

    public JPALiga() {
    }

    public JPALiga(final String bezeichnung) {
	this.bezeichnung = bezeichnung;
    }

    public Long getId() {
	return id;
    }

    public void setId(final Long id) {
	this.id = id;
    }

    public String getBezeichnung() {
	return bezeichnung;
    }

    public void setBezeichnung(final String bezeichnung) {
	this.bezeichnung = bezeichnung;
    }

    @SuppressWarnings("unchecked")
    static List<JPAKind> getKinder(final EntityManager em, final JPALiga liga) {
	final Query namedQuery = em.createNamedQuery(JPAKind.KINDER_DER_LIGA);
	namedQuery.setParameter("liga", liga.getId());
	final List<JPAKind> list = namedQuery.getResultList();
	return list;
    }

    static void addKind(final EntityManager em, final JPALiga liga, final JPAKind kind) {
	kind.setLiga(liga.getId());
	em.getTransaction().begin();
	em.persist(kind);
	em.getTransaction().commit();
    }

    public static void addTermin(final EntityManager em, final JPALiga liga, final JPATermin t1) {
	t1.setLiga(liga.getId());
	em.getTransaction().begin();
	em.persist(t1);
	em.getTransaction().commit();
    }

}
