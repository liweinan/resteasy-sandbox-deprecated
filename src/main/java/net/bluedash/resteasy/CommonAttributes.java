package net.bluedash.resteasy;

/**
 * 10 16 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Attributes common across all atom types
 *
 * TODO remove this file when JBoss AS includes RESTEasy 2.3.4.Final or higher
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CommonAttributes
{
   private String language;
   private URI base;


   private Map extensionAttributes = new HashMap();

   @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace")
   public String getLanguage()
   {
      return language;
   }

   public void setLanguage(String language)
   {
      this.language = language;
   }

   @XmlAttribute(namespace = "http://www.w3.org/XML/1998/namespace")
   public URI getBase()
   {
      return base;
   }

   public void setBase(URI base)
   {
      this.base = base;
   }

   @XmlAnyAttribute
   public Map getExtensionAttributes()
   {
      return extensionAttributes;
   }
}
