package net.bluedash.resteasy;

import javax.xml.bind.annotation.*;

/**
 * 10 17 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class MediaTypeHashEntryType {

    @XmlAttribute
    public String key;

    @XmlValue
    public String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
