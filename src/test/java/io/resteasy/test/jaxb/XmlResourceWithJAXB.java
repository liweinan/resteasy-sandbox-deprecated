package io.resteasy.test.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@XmlRootElement
public class XmlResourceWithJAXB {
    String attr1;
    String attr2;
    @XmlElement(name = "attr_1")
    public String getAttr1() {
        return attr1;
    }
    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }
    @XmlElement
    public String getAttr2() {
        return attr2;
    }
    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }
}
