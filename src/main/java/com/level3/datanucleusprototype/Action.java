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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zendle.joe
 */
@Entity
@Table(name = "action")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Action.findAll", query = "SELECT a FROM Action a"),
  @NamedQuery(name = "Action.findByGuid", query = "SELECT a FROM Action a WHERE a.guid = :guid"),
  @NamedQuery(name = "Action.findByActionType", query = "SELECT a FROM Action a WHERE a.actionType = :actionType")})
public class Action extends IdentityByUUID implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "action_type")
  private Integer actionType;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "action1")
  private AlertActionParameter alertActionParameter;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "action")
  private Collection<Alert> alertCollection;

  public Action() {
  }

  public Action(String guid) {
    this.guid = guid;
  }

  public Integer getActionType() {
    return actionType;
  }

  public void setActionType(Integer actionType) {
    this.actionType = actionType;
  }

  public AlertActionParameter getAlertActionParameter() {
    return alertActionParameter;
  }

  public void setAlertActionParameter(AlertActionParameter alertActionParameter) {
    this.alertActionParameter = alertActionParameter;
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
