package org.unidal.webres.tag.css;

import org.unidal.webres.tag.resource.ResourceTagModelSupport;

public class UseCssTagModel extends ResourceTagModelSupport<UseCssTagRenderType> {
   private String m_id;

   private String m_target;

   private Boolean m_secure;

   private Object m_value;

   public UseCssTagModel() {
      super(UseCssTagRenderType.EXTERNALIZED);
   }

   public String getId() {
      return m_id;
   }

   public Boolean getSecure() {
      return m_secure;
   }

   public String getTarget() {
      return m_target;
   }

   public Object getValue() {
      return m_value;
   }

   public void setId(String id) {
      m_id = id;
   }

   public void setSecure(Boolean secure) {
      m_secure = secure;
   }

   public void setTarget(String target) {
      m_target = target;
   }

   public void setValue(Object value) {
      m_value = value;
   }
}
