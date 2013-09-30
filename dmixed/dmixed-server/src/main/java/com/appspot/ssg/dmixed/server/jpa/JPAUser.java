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
@Table(name = "user")
@NamedQueries({ @NamedQuery(name = JPAUser.FINDUSER, query = "SELECT user FROM JPAUser user WHERE user.name = :name and user.email = :email"),
	@NamedQuery(name = JPAUser.ALLE_USER, query = "SELECT user FROM JPAUser user") })
public class JPAUser {

    public static final String FINDUSER = "FINDUSER";
    public static final String ALLE_USER = "ALLE_USER";

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private boolean admin;

    public JPAUser() {

    }

    public final Long getId() {
	return id;
    }

    public final void setId(final Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public final String getEmail() {
	return email;
    }

    public final void setEmail(final String email) {
	this.email = email;
    }

    public boolean isAdmin() {
	return admin;
    }

    public void setAdmin(final boolean admin) {
	this.admin = admin;
    }

    @SuppressWarnings("unchecked")
    static List<JPAKind> getKinder(final EntityManager em, final JPAUser user) {
	final Query namedQuery = em.createNamedQuery(JPAKind.KINDER_DER_ELTERN);
	namedQuery.setParameter("familie", user.getId());
	final List<JPAKind> list = namedQuery.getResultList();
	return list;
    }

    static void addKind(final EntityManager em, final JPAUser user, final JPAKind kind) {
	kind.setFamilie(user.getId());
	em.getTransaction().begin();
	em.persist(kind);
	em.getTransaction().commit();
    }

}
