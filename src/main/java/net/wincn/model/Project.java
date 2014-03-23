package net.wincn.model;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Model;

@TableBind(tableName = "projects", pkName = "id")
public class Project extends Model<Project> {
	private static final long serialVersionUID = 2779991564135437327L;
	public static final Project dao = new Project();
}
