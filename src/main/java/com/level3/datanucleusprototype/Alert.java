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
@Table(name = "alert")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Alert.findAll", query = "SELECT a FROM Alert a"),
  @NamedQuery(name = "Alert.findByGuid", query = "SELECT a FROM Alert a WHERE a.guid = :guid"),
  @NamedQuery(name = "Alert.findByTimezone", query = "SELECT a FROM Alert a WHERE a.timezone = :timezone"),
  @NamedQuery(name = "Alert.findByPeriod", query = "SELECT a FROM Alert a WHERE a.period = :period")})
public class Alert extends IdentityByUUID implements Serializable {
  private static final long serialVersionUID = 1L;

  @Basic(optional = false)
  @Column(name = "timezone")
  private int timezone;
  @Column(name = "period")
  private Integer period;
  @JoinColumn(name = "action", referencedColumnName = "guid")
  @ManyToOne(optional = false)
  private Action action;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "alert")
  private Collection<Metric> metricCollection;

  public Alert() {
  }

  public Alert(String guid) {
    this.guid = guid;
  }

  public Alert(String guid, int timezone) {
    this.guid = guid;
    this.timezone = timezone;
  }

  public int getTimezone() {
    return timezone;
  }

  public void setTimezone(int timezone) {
    this.timezone = timezone;
  }

  public Integer getPeriod() {
    return period;
  }

  public void setPeriod(Integer period) {
    this.period = period;
  }

  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  @XmlTransient
  public Collection<Metric> getMetricCollection() {
    return metricCollection;
  }

  public void setMetricCollection(Collection<Metric> metricCollection) {
    this.metricCollection = metricCollection;
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
    if (!(object instanceof Alert)) {
      return false;
    }
    Alert other = (Alert) object;
    if ((this.guid == null && other.guid != null) || (this.guid != null && !this.guid.equals(other.guid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.level3.datanucleusprototype.Alert[ guid=" + guid + " ]";
  }
  
}
