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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ACTION")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Action.findAll", query = "SELECT a FROM Action a"),
   @NamedQuery(name = "Action.findByGuid", query = "SELECT a FROM Action a WHERE a.guid = :guid"),
   @NamedQuery(name = "Action.findByActionType", query = "SELECT a FROM Action a WHERE a.actionType = :actionType")})
public class Action implements Serializable {
   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @Column(name = "GUID")
   private String guid;
   @Column(name = "ACTION_TYPE")
   private Integer actionType;
   @JoinColumn(name = "ALERT", referencedColumnName = "GUID")
   @ManyToOne(optional = false)
   private Alert alert;
   @OneToOne(cascade = CascadeType.ALL, mappedBy = "action1")
   private AlertActionParameter alertActionParameter;

   public Action() {
   }

   public Action(String guid) {
      this.guid = guid;
   }

   public String getGuid() {
      return guid;
   }

   public void setGuid(String guid) {
      this.guid = guid;
   }

   public Integer getActionType() {
      return actionType;
   }

   public void setActionType(Integer actionType) {
      this.actionType = actionType;
   }

   public Alert getAlert() {
      return alert;
   }

   public void setAlert(Alert alert) {
      this.alert = alert;
   }

   public AlertActionParameter getAlertActionParameter() {
      return alertActionParameter;
   }

   public void setAlertActionParameter(AlertActionParameter alertActionParameter) {
      this.alertActionParameter = alertActionParameter;
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
      if (!(object instanceof Action)) {
         return false;
      }
      Action other = (Action) object;
      if ((this.guid == null && other.guid != null) || (this.guid != null && !this.guid.equals(other.guid))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "com.level3.datanucleusprototype.Action[ guid=" + guid + " ]";
   }
   
}
