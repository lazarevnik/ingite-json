package org.apache.ignite.internal.processors.query.h2.twostep.msg;

import java.lang.reflect.Method;

import org.apache.ignite.IgniteCheckedException;
import org.apache.ignite.internal.GridKernalContext;
import org.h2.value.Value;
import org.h2.value.ValueJson;

import com.fasterxml.jackson.databind.JsonNode;

public class GridH2Json extends GridH2ValueMessage {
	
	/** */
//	private static final Method JSON_FROM_BYTES;
//	
//	static {
//		try {
//			JSON_FROM_BYTES = Class.forName("org.h2.value.ValueJson").getMethod("get", byte[].class);
//		} catch (NoSuchMethodException | ClassNotFoundException ignored) {
//            throw new IllegalStateException("Check H2 version in classpath.");
//        }
//	}
	
	private JsonNode data;
	
	public GridH2Json (Value v) {
		assert v.getType() == Value.JSON;
		
		data = (JsonNode) v.getObject();
	}
	
	public GridH2Json (JsonNode data) {
		this.data = data;
	}

	public GridH2Json() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Value value(GridKernalContext ctx) throws IgniteCheckedException {
		return ValueJson.get(data);
	}
	
	@Override
	public short directType() {
		// TODO Auto-generated method stub
		return -23;
	}

	@Override
	public byte fieldsCount() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	@Override
	public String toString() {
		return data.toString() + "::JSON";
	}

}
