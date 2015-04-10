package com.ctrip.hermes.meta.pojo;

import java.util.HashMap;
import java.util.Map;

import com.ctrip.hermes.meta.entity.Codec;
import com.ctrip.hermes.meta.entity.Property;

public class CodecView {
	private String type;

	private Map<String, Object> config;

	public CodecView() {

	}

	public CodecView(Codec codec) {
		this.type = codec.getType();
		config = new HashMap<>();
		for (Property property : codec.getProperties()) {
			config.put(property.getName(), property.getValue());
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, Object> getConfig() {
		return config;
	}

	public void setConfig(Map<String, Object> config) {
		this.config = config;
	}

	public Codec toMetaCodec() {
		Codec codec = new Codec();
		codec.setType(this.type);
		for (Map.Entry<String, Object> entry : this.config.entrySet()) {
			Property prop = new Property();
			prop.setName(entry.getKey());
			prop.setValue(String.valueOf(entry.getValue()));
			codec.addProperty(prop);
		}
		return codec;
	}

}
