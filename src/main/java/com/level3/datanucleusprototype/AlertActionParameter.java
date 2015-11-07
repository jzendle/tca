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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zendle.joe
 */
@Entity
@Table(name = "alert_action_parameter")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "AlertActionParameter.findAll", query = "SELECT a FROM AlertActionParameter a"),
  @NamedQuery(name = "AlertActionParameter.findByAction", query = "SELECT a FROM AlertActionParameter a WHERE a.action = :action"),
  @NamedQuery(name = "AlertActionParameter.findByActionParameter", query = "SELECT a FROM AlertActionParameter a WHERE a.actionParameter = :actionParameter"),
  @NamedQuery(name = "AlertActionParameter.findByValue", query = "SELECT a FROM AlertActionParameter a WHERE a.value = :value")})
public class AlertActionParameter implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "action")
  private String action;
  @Basic(optional = false)
  @Column(name = "action_parameter")
  private int actionParameter;
  @Column(name = "value")
  private String value;
  @JoinColumn(name = "action", referencedColumnName = "guid", insertable = false, updatable = false)
  @OneToOne(optional = false)
  private Action action1;

  public AlertActionParameter() {
  }

  public AlertActionParameter(String action) {
    this.action = action;
  }

  public AlertActionParameter(String action, int actionParameter) {
    this.action = action;
    this.actionParameter = actionParameter;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public int getActionParameter() {
    return actionParameter;
  }

  public void setActionParameter(int actionParameter) {
    this.actionParameter = actionParameter;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Action getAction1() {
    return action1;
  }

  public void setAction1(Action action1) {
    this.action1 = action1;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (action != null ? action.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AlertActionParameter)) {
      return false;
    }
    AlertActionParameter other = (AlertActionParameter) object;
    if ((this.action == null && other.action != null) || (this.action != null && !this.action.equals(other.action))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.level3.datanucleusprototype.AlertActionParameter[ action=" + action + " ]";
  }
  
}
