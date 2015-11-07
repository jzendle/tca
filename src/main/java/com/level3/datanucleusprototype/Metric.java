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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "metric")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Metric.findAll", query = "SELECT m FROM Metric m"),
  @NamedQuery(name = "Metric.findByGuid", query = "SELECT m FROM Metric m WHERE m.guid = :guid"),
  @NamedQuery(name = "Metric.findByThresholdType", query = "SELECT m FROM Metric m WHERE m.thresholdType = :thresholdType"),
  @NamedQuery(name = "Metric.findByThreshold", query = "SELECT m FROM Metric m WHERE m.threshold = :threshold")})
public class Metric extends IdentityByUUID implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "threshold_type")
  private Integer thresholdType;
  @Column(name = "threshold")
  private String threshold;
  @JoinColumn(name = "alert", referencedColumnName = "guid")
  @ManyToOne(optional = false)
  private Alert alert;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "metric")
  private Collection<TcaInstance> tcaInstanceCollection;

  public Metric() {
  }

  public Metric(String guid) {
    this.guid = guid;
  }

  public Integer getThresholdType() {
    return thresholdType;
  }

  public void setThresholdType(Integer thresholdType) {
    this.thresholdType = thresholdType;
  }

  public String getThreshold() {
    return threshold;
  }

  public void setThreshold(String threshold) {
    this.threshold = threshold;
  }

  public Alert getAlert() {
    return alert;
  }

  public void setAlert(Alert alert) {
    this.alert = alert;
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
    if (!(object instanceof Metric)) {
      return false;
    }
    Metric other = (Metric) object;
    if ((this.guid == null && other.guid != null) || (this.guid != null && !this.guid.equals(other.guid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.level3.datanucleusprototype.Metric[ guid=" + guid + " ]";
  }
  
}
