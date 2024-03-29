package com.hotent.bpmx.plugin.task.userassign.context;

import com.hotent.bpmx.api.constant.ExtractType;
import com.hotent.bpmx.api.constant.LogicType;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class EnumTypeProcessor implements JsonValueProcessor {

	@Override
	public Object processArrayValue(Object obj, JsonConfig config) {
		return null;
	}

	@Override
	public Object processObjectValue(String key, Object obj, JsonConfig config) {
		if(obj instanceof ExtractType){
			return ((ExtractType) obj).getKey();
		}
		else if(obj instanceof LogicType){
			return ((LogicType) obj).getKey();
		}
		return "";
	}

}
