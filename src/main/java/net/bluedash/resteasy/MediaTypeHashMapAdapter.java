package net.bluedash.resteasy;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.*;

/**
 * 10 17 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class MediaTypeHashMapAdapter extends XmlAdapter<MediaTypeHashMapType, Map<String, String>> {

    @Override
    public MediaTypeHashMapType marshal(Map<String, String> arg0) throws Exception {
        MediaTypeHashMapType hashMapType = new MediaTypeHashMapType();

        for (java.util.Map.Entry entry : arg0.entrySet()) {
            MediaTypeHashEntryType hashEntryType = new MediaTypeHashEntryType();
            hashEntryType.key = (String) entry.getKey();
            hashEntryType.value = (String) entry.getValue();
            hashMapType.paramTypes.add(hashEntryType);
        }
        return hashMapType;
    }

    @Override
    public Map<String, String> unmarshal(MediaTypeHashMapType arg0) throws Exception {
        TreeMap<String, String> map = new TreeMap<String, String>();
        for (MediaTypeHashEntryType HashEntryType : arg0.paramTypes) {
            map.put(HashEntryType.key, HashEntryType.value);
        }
        return map;
    }

}
