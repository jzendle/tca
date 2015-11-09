/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.level3.tca.model;

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
 * @author jzendle
 */
@Entity
@Table(name = "ALERT")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Alert.findAll", query = "SELECT a FROM Alert a"),
   @NamedQuery(name = "Alert.findByGuid", query = "SELECT a FROM Alert a WHERE a.guid = :guid"),
   @NamedQuery(name = "Alert.findByPeriod", query = "SELECT a FROM Alert a WHERE a.period = :period"),
   @NamedQuery(name = "Alert.findByTimezone", query = "SELECT a FROM Alert a WHERE a.timezone = :timezone")})
public class Alert implements Serializable {
   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @Column(name = "GUID")
   private String guid;
   @Basic(optional = false)
   @Column(name = "PERIOD")
   private int period;
   @Basic(optional = false)
   @Column(name = "TIMEZONE")
   private int timezone;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "alert")
   private Collection<Action> actionCollection;
   @JoinColumn(name = "METRIC", referencedColumnName = "GUID")
   @ManyToOne(optional = false)
   private Metric metric;

   public Alert() {
   }

   public Alert(String guid) {
      this.guid = guid;
   }

   public Alert(String guid, int period, int timezone) {
      this.guid = guid;
      this.period = period;
      this.timezone = timezone;
   }

   public String getGuid() {
      return guid;
   }

   public void setGuid(String guid) {
      this.guid = guid;
   }

   public int getPeriod() {
      return period;
   }

   public void setPeriod(int period) {
      this.period = period;
   }

   public int getTimezone() {
      return timezone;
   }

   public void setTimezone(int timezone) {
      this.timezone = timezone;
   }

   @XmlTransient
   public Collection<Action> getActionCollection() {
      return actionCollection;
   }

   public void setActionCollection(Collection<Action> actionCollection) {
      this.actionCollection = actionCollection;
   }

   public Metric getMetric() {
      return metric;
   }

   public void setMetric(Metric metric) {
      this.metric = metric;
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
