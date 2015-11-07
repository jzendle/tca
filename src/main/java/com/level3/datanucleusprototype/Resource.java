/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.level3.datanucleusprototype;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zendle.joe
 */
@Entity
@Table(name = "resource")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Resource.findAll", query = "SELECT r FROM Resource r"),
  @NamedQuery(name = "Resource.findByGuid", query = "SELECT r FROM Resource r WHERE r.guid = :guid"),
  @NamedQuery(name = "Resource.findByCircuit", query = "SELECT r FROM Resource r WHERE r.circuit = :circuit"),
  @NamedQuery(name = "Resource.findByBclli", query = "SELECT r FROM Resource r WHERE r.bclli = :bclli"),
  @NamedQuery(name = "Resource.findByEvc", query = "SELECT r FROM Resource r WHERE r.evc = :evc"),
  @NamedQuery(name = "Resource.findByGroup", query = "SELECT r FROM Resource r WHERE r.group = :group")})
public class Resource extends IdentityByUUID implements Serializable {
  private static final long serialVersionUID = 1L;
  @Column(name = "circuit")
  private String circuit;
  @Column(name = "bclli")
  private String bclli;
  @Column(name = "evc")
  private String evc;
  @Column(name = "group")
  private String group;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "resource")
  private Collection<TcaInstance> tcaInstanceCollection;

  public Resource() {
  }

  public Resource(String guid) {
    this.guid = guid;
  }

  public String getCircuit() {
    return circuit;
  }

  public void setCircuit(String circuit) {
    this.circuit = circuit;
  }

  public String getBclli() {
    return bclli;
  }

  public void setBclli(String bclli) {
    this.bclli = bclli;
  }

  public String getEvc() {
    return evc;
  }

  public void setEvc(String evc) {
    this.evc = evc;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  @XmlTransient
  public Collection<TcaInstance> getTcaInstanceCollection() {
    return tcaInstanceCollection;
  }

  public void setTcaInstanceCollection(Collection<TcaInstance> tcaInstanceCollection) {
    this.tcaInstanceCollection = tcaInstanceCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (guid != null ? guid.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Resource)) {
      return false;
    }
    Resource other = (Resource) object;
    if ((this.guid == null && other.guid != null) || (this.guid != null && !this.guid.equals(other.guid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.level3.datanucleusprototype.Resource[ guid=" + guid + " ]";
  }
  
}
