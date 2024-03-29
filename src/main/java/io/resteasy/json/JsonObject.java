package io.resteasy.json;

import org.jboss.resteasy.annotations.providers.NoJackson;

@NoJackson
public class JsonObject {

	private String key;
	private String value;

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

    @Override
    public String toString() {
        return "KEY: " + key + " VALUE: " + value;
    }
}
