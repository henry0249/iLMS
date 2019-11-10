package com.hotent.mini.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hotent.base.core.util.BeanUtils;
import com.hotent.base.core.util.string.StringUtil;
import com.hotent.bpmx.api.model.identity.BpmIdentity;
import com.hotent.bpmx.core.model.identity.DefaultBpmIdentity;

public class BpmIdentityUtil {
	
 
	
		/**
		 * 将数据 [{nodeId:"userTask1",executors:[{id:"",name:""},{id:"",name:""}]}],返回为
		 * 对象执行人。
		 * @param executors
		 * @return 
		 * Map<String,List<BpmIdentity>>
		 */
		public static Map<String,List<BpmIdentity>> getBpmIdentity(String executors){
			Map<String,List<BpmIdentity>> map=new HashMap<String, List<BpmIdentity>>();
			if(StringUtil.isEmpty(executors)) return map;
			JSONArray jsonArray=JSONArray.fromObject(executors);
			for(Object obj:jsonArray){
				JSONObject jsonNode=(JSONObject)obj;
				String nodeId=jsonNode.getString("nodeId");
				JSONArray users= jsonNode.getJSONArray("executors");
				List<BpmIdentity> userList=new ArrayList<BpmIdentity>();
				for(Object userObj:users){
					JSONObject user=(JSONObject)userObj;
					BpmIdentity bpmInentity=(BpmIdentity) DefaultBpmIdentity.getIdentityByUserId(user.getString("id")
							, user.getString("name"));
					
					userList.add(bpmInentity);
				}
				if(BeanUtils.isNotEmpty(userList)){
					map.put(nodeId, userList);
				}
			}
			return map;
		}

}
