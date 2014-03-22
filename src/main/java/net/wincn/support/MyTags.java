package net.wincn.support;

import java.io.IOException;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 分类标签<br>
 * 参数：{parent_id:上级主键} 返回值：{list:分类列表}
 * 
 * @author gefangshuai
 */
@SuppressWarnings("rawtypes")
public class MyTags implements TemplateDirectiveModel {

	@Override
	public void execute(Environment arg0, Map arg1, TemplateModel[] arg2, TemplateDirectiveBody arg3)
			throws TemplateException, IOException {

	}

}