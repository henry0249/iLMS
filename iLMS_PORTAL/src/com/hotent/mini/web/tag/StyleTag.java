package com.hotent.mini.web.tag;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotent.base.core.util.BeanUtils;
import com.hotent.portal.util.PortalUtil;


/**
 * 用于实现个性化皮肤。<br/>
 * <pre>
 * 使用方法如下：
 * 
 * &lt;f:link href="web.css" >&lt;/f:link>
 * </pre>
 * @author hotent
 *
 */
@SuppressWarnings("serial")
public class StyleTag extends BodyTagSupport {
	protected Logger logger = LoggerFactory.getLogger(StyleTag.class);
	private String href;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int doStartTag() throws JspTagException {
		return EVAL_BODY_BUFFERED;
	}
	
	private String getOutput() throws Exception
	{
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		logger.info(request.getRequestURI());
		StringBuffer content = new StringBuffer("<link title=\"index\" name=\"styleTag\" rel=\"stylesheet\" type=\"text/css\" href=\"");
		content.append(request.getContextPath());
		
		String webappPath = request.getServletContext().getRealPath("/");
		content.append("/css");
		String styleName= null;
		if(BeanUtils.validClass("com.hotent.portal.util.PortalUtil") && BeanUtils.isNotEmpty(PortalUtil.getCurrentUserSetting())){
			styleName = PortalUtil.getCurrentUserSetting().getSkinName();
		}
		if (styleName != null) {
			webappPath += "css/"+styleName+"/"+href;
			boolean fileIsExists = new File(webappPath).exists();
			if(fileIsExists){
			  content.append("/").append(styleName);
			}
		}
		content.append("/");
		content.append(href);
		content.append("\"></link>");
		return content.toString();
	}
	

	public int doEndTag() throws JspTagException {

		try {
			String str = getOutput();
			pageContext.getOut().print(str);
		} catch (Exception e) {
			throw new JspTagException(e);
		}
		return SKIP_BODY;
	}

}
