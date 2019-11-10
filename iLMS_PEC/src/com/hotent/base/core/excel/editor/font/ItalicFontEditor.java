package com.hotent.base.core.excel.editor.font;

import com.hotent.base.core.excel.editor.IFontEditor;
import com.hotent.base.core.excel.style.font.Font;

/**
 * 实现一些常用的字体<br/>
 * 该类用于设置斜体
 * 
 * @author zxh
 * 
 */
public class ItalicFontEditor implements IFontEditor {

	public void updateFont(Font font) {
		font.italic(true);
	}

}
