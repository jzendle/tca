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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jzendle
 */
@Entity
@Table(name = "METRIC")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Metric.findAll", query = "SELECT m FROM Metric m"),
   @NamedQuery(name = "Metric.findByGuid", query = "SELECT m FROM Metric m WHERE m.guid = :guid"),
   @NamedQuery(name = "Metric.findByThreshold", query = "SELECT m FROM Metric m WHERE m.threshold = :threshold"),
   @NamedQuery(name = "Metric.findByThresholdType", query = "SELECT m FROM Metric m WHERE m.thresholdType = :thresholdType")})
public class Metric extends IdentityByGuid implements Serializable {

   private static final long serialVersionUID = 1L;

   @Basic(optional = false)
   @Column(name = "THRESHOLD")
   private String threshold;
   @Column(name = "THRESHOLD_TYPE")
   private Integer thresholdType;
   @JoinColumn(name = "GUID", referencedColumnName = "METRIC", insertable = false, updatable = false)
   @OneToOne(optional = false)
   private TcaInstance tcaInstance;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "metric")
   private Collection<Alert> alertCollection;

   public Metric() {
      super();
   }

   public Metric(String guid) {
      super(guid);
   }

   public Metric(String guid, String threshold) {
      super(guid);
      this.threshold = threshold;
   }

   public String getThreshold() {
      return threshold;
   }

   public void setThreshold(String threshold) {
      this.threshold = threshold;
   }

   public Integer getThresholdType() {
      return thresholdType;
   }

   public void setThresholdType(Integer thresholdType) {
      this.thresholdType = thresholdType;
   }

   public TcaInstance getTcaInstance() {
      return tcaInstance;
   }

   public void setTcaInstance(TcaInstance tcaInstance) {
      this.tcaInstance = tcaInstance;
   }

   @XmlTransient
   public Collection<Alert> getAlertCollection() {
      return alertCollection;
   }

   public void setAlertCollection(Collection<Alert> alertCollection) {
      this.alertCollection = alertCollection;
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
