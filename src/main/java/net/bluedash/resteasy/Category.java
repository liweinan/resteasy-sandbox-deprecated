package net.bluedash.resteasy;

/**
 * 10 16 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;

/**
 * <p>Per RFC4287:</p>
 * <p/>
 * <pre>
 *  The "atom:category" element conveys information about a category
 *  associated with an entry or feed.  This specification assigns no
 *  meaning to the content (if any) of this element.
 * <p/>
 *  atomCategory =
 *     element atom:category {
 *        atomCommonAttributes,
 *        attribute term { text },
 *        attribute scheme { atomUri }?,
 *        attribute label { text }?,
 *        undefinedContent
 *     }
 * </pre>
 *
 * TODO remove this file when JBoss AS includes RESTEasy 2.3.4.Final or higher
 */
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Category extends CommonAttributes
{
   private String term;

   private URI scheme;

   private String label;

   @XmlAttribute
   public String getTerm()
   {
      return term;
   }

   public void setTerm(String term)
   {
      this.term = term;
   }

   @XmlAttribute
   public URI getScheme()
   {
      return scheme;
   }

   public void setScheme(URI scheme)
   {
      this.scheme = scheme;
   }

   @XmlAttribute
   public String getLabel()
   {
      return label;
   }

   public void setLabel(String label)
   {
      this.label = label;
   }
}
