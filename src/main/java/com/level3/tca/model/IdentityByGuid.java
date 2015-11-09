/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.level3.tca.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author zendle.joe
 */
@MappedSuperclass
public abstract class IdentityByGuid implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "GUID")
   @Basic(optional = false)

   protected String guid;

   public IdentityByGuid() {
      this.guid = UUID.randomUUID().toString();
   }

   public IdentityByGuid(String guid) {
      this.guid = guid;
   }

   public String getGuid() {
      return this.guid;
   }

   public String setGuid(String guid) {
      return this.guid = guid;
   }

   @Override
   public int hashCode() {
      return guid.hashCode();
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (!(obj instanceof IdentityByGuid)) {
         return false;
      }
      IdentityByGuid other = (IdentityByGuid) obj;
      return getGuid().equals(other.getGuid());
   }
}
