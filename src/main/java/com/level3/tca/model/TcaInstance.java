/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.level3.tca.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jzendle
 */
@Entity
@Table(name = "TCA_INSTANCE")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "TcaInstance.findAll", query = "SELECT t FROM TcaInstance t"),
   @NamedQuery(name = "TcaInstance.findByGuid", query = "SELECT t FROM TcaInstance t WHERE t.guid = :guid"),
   @NamedQuery(name = "TcaInstance.findByResource", query = "SELECT t FROM TcaInstance t WHERE t.resource = :resource"),
   @NamedQuery(name = "TcaInstance.findByMetric1", query = "SELECT t FROM TcaInstance t WHERE t.metric1 = :metric1"),
   @NamedQuery(name = "TcaInstance.findByOwner", query = "SELECT t FROM TcaInstance t WHERE t.owner = :owner"),
   @NamedQuery(name = "TcaInstance.findByQos", query = "SELECT t FROM TcaInstance t WHERE t.qos = :qos")})
public class TcaInstance extends IdentityByGuid implements Serializable {
   private static final long serialVersionUID = 1L;
   
   @Basic(optional = false)
   @Column(name = "RESOURCE")
   private String resource;
   @Basic(optional = false)
   @Column(name = "METRIC")
   private String metric1;
   @Basic(optional = false)
   @Column(name = "OWNER")
   private String owner;
   @Basic(optional = false)
   @Column(name = "QOS")
   private int qos;
   @OneToOne(cascade = CascadeType.ALL, mappedBy = "tcaInstance")
   private Metric metric;
   @OneToOne(cascade = CascadeType.ALL, mappedBy = "tcaInstance")
   private Resource resource1;

   public TcaInstance() {
      super();
   }

   public TcaInstance(String guid) {
      super(guid);
   }

   public TcaInstance(String guid, String resource, String metric1, String owner, int qos) {
     super(guid);
      this.resource = resource;
      this.metric1 = metric1;
      this.owner = owner;
      this.qos = qos;
   }


   public String getResource() {
      return resource;
   }

   public void setResource(String resource) {
      this.resource = resource;
   }

   public String getMetric1() {
      return metric1;
   }

   public void setMetric1(String metric1) {
      this.metric1 = metric1;
   }

   public String getOwner() {
      return owner;
   }

   public void setOwner(String owner) {
      this.owner = owner;
   }

   public int getQos() {
      return qos;
   }

   public void setQos(int qos) {
      this.qos = qos;
   }

   public Metric getMetric() {
      return metric;
   }

   public void setMetric(Metric metric) {
      this.metric1 = metric.getGuid();
      this.metric = metric;
   }

   public Resource getResource1() {
      return resource1;
   }

   public void setResource1(Resource resource1) {
      this.resource = resource1.getGuid();
      this.resource1 = resource1;
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
