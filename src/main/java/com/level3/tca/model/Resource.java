/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.level3.tca.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "RESOURCE")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Resource.findAll", query = "SELECT r FROM Resource r"),
   @NamedQuery(name = "Resource.findByGuid", query = "SELECT r FROM Resource r WHERE r.guid = :guid"),
   @NamedQuery(name = "Resource.findByBclli", query = "SELECT r FROM Resource r WHERE r.bclli = :bclli"),
   @NamedQuery(name = "Resource.findByCircuit", query = "SELECT r FROM Resource r WHERE r.circuit = :circuit"),
   @NamedQuery(name = "Resource.findByEvc", query = "SELECT r FROM Resource r WHERE r.evc = :evc"),
   @NamedQuery(name = "Resource.findByGroup", query = "SELECT r FROM Resource r WHERE r.group = :group")})
public class Resource extends IdentityByGuid implements Serializable {
   private static final long serialVersionUID = 1L;

   @Column(name = "BCLLI")
   private String bclli;
   @Basic(optional = false)
   @Column(name = "CIRCUIT")
   private String circuit;
   @Column(name = "EVC")
   private String evc;
   @Column(name = "`GROUP`")
   private String group;
   @JoinColumn(name = "GUID", referencedColumnName = "RESOURCE", insertable = false, updatable = false)
   @OneToOne(optional = false)
   private TcaInstance tcaInstance;

   public Resource() {
      super();
   }

   public Resource(String guid) {
      super(guid);
   }

   public Resource(String guid, String circuit) {
      super(guid);
      this.circuit = circuit;
   }

   public String getBclli() {
      return bclli;
   }

   public void setBclli(String bclli) {
      this.bclli = bclli;
   }

   public String getCircuit() {
      return circuit;
   }

   public void setCircuit(String circuit) {
      this.circuit = circuit;
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

   public TcaInstance getTcaInstance() {
      return tcaInstance;
   }

   public void setTcaInstance(TcaInstance tcaInstance) {
      this.tcaInstance = tcaInstance;
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
