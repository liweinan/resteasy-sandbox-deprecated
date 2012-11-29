package net.bluedash.resteasy.form;

import javax.ws.rs.FormParam;

/**
 * 11 29 2012
 *
 * @author <a href="mailto:l.weinan@gmail.com">Weinan Li</a>
 */
public class Foo {
    @FormParam("bar")
    private String bar;

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}
