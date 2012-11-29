package net.bluedash.resteasy.form;

import org.jboss.resteasy.annotations.Form;

import java.util.HashMap;
import java.util.Map;

/**
 * 11 29 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class MyForm {
    @Form(prefix = "myMap")
    private Map<String, Foo> myMap = new HashMap<String, Foo>();

    public Map<String, Foo> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, Foo> myMap) {
        this.myMap = myMap;
    }
}
