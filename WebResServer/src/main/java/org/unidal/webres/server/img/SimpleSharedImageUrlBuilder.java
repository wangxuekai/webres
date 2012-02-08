package org.unidal.webres.server.img;

import org.unidal.webres.resource.ResourceConstant;
import org.unidal.webres.resource.annotation.ContextPath;
import org.unidal.webres.resource.api.IImage;
import org.unidal.webres.resource.api.IResourceUrn;
import org.unidal.webres.resource.spi.IResourceContext;
import org.unidal.webres.resource.spi.IResourceRegisterable;
import org.unidal.webres.resource.spi.IResourceUrlBuilder;

public class SimpleSharedImageUrlBuilder implements IResourceUrlBuilder<IImage>,
      IResourceRegisterable<SimpleSharedImageUrlBuilder> {
   private String m_contextPath;

   private String m_servletPath;

   public SimpleSharedImageUrlBuilder(String servletPath) {
      m_servletPath = servletPath;

      if (servletPath != null) {
         if (!servletPath.startsWith("/") && servletPath.endsWith("/")) {
            throw new RuntimeException("servletPath should be null or starting with '/' but not ending with '/'.");
         }
      }
   }

   @Override
   public String build(IResourceContext ctx, IImage image) {
      StringBuilder sb = new StringBuilder(128);

      if (m_contextPath != null) {
         sb.append(m_contextPath);
      }

      if (m_servletPath != null) {
         sb.append(m_servletPath);
      }

      IResourceUrn urn = image.getMeta().getUrn();

      sb.append('/').append(urn.getResourceTypeName());
      sb.append('/').append(urn.getNamespace());

      if (ctx.getPermutation() != null && !ctx.isFallbackPermutation()) {
         sb.append('/').append(ctx.getPermutation().toExternal());
      }

      sb.append(urn.getPathInfo());

      return sb.toString();
   }

   @Override
   public SimpleSharedImageUrlBuilder getRegisterInstance() {
      return this;
   }

   @Override
   public String getRegisterKey() {
      return ResourceConstant.Image.Shared;
   }

   @Override
   public Class<? super SimpleSharedImageUrlBuilder> getRegisterType() {
      return IResourceUrlBuilder.class;
   }

   @ContextPath
   public void setContextPath(String contextPath) {
      m_contextPath = contextPath;
   }
}
