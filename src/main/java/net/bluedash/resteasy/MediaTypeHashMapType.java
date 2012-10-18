package net.bluedash.resteasy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * 10 17 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
@XmlRootElement(name = "media-type-parameters")
public class MediaTypeHashMapType {

    @XmlElement(name="media-type-parameter-types", required = true)
    public List<MediaTypeHashEntryType> paramTypes = new ArrayList<MediaTypeHashEntryType>();

    public List<MediaTypeHashEntryType> getParamTypes() {
        return paramTypes;
    }

}
