/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.level3.datanucleusprototype;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zendle.joe
 */
@Entity
@Table(name = "tca_instance")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TcaInstance.findAll", query = "SELECT t FROM TcaInstance t"),
  @NamedQuery(name = "TcaInstance.findByGuid", query = "SELECT t FROM TcaInstance t WHERE t.guid = :guid"),
  @NamedQuery(name = "TcaInstance.findByQos", query = "SELECT t FROM TcaInstance t WHERE t.qos = :qos"),
  @NamedQuery(name = "TcaInstance.findByOwner", query = "SELECT t FROM TcaInstance t WHERE t.owner = :owner")})
public class TcaInstance extends IdentityByUUID implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "qos")
  private Integer qos;
  @Column(name = "owner")
  private String owner;
  @JoinColumn(name = "metric", referencedColumnName = "guid")
  @ManyToOne(optional = false)
  private Metric metric;
  @JoinColumn(name = "resource", referencedColumnName = "guid")
  @ManyToOne(optional = false)
  private Resource resource;

  public TcaInstance() {
  }

  public TcaInstance(String guid) {
    this.guid = guid;
  }

  public Integer getQos() {
    return qos;
  }

  public void setQos(Integer qos) {
    this.qos = qos;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Metric getMetric() {
    return metric;
  }

  public void setMetric(Metric metric) {
    this.metric = metric;
  }

  public Resource getResource() {
    return resource;
  }

  public void setResource(Resource resource) {
    this.resource = resource;
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
    if (!(object instanceof TcaInstance)) {
      return false;
    }
    TcaInstance other = (TcaInstance) object;
    if ((this.guid == null && other.guid != null) || (this.guid != null && !this.guid.equals(other.guid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.level3.datanucleusprototype.TcaInstance[ guid=" + guid + " ]";
  }
  
}
