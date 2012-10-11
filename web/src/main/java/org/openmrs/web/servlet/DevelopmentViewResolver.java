package org.openmrs.web.servlet;

import org.openmrs.module.Module;
import org.openmrs.module.ModuleUtil;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class DevelopmentViewResolver extends InternalResourceViewResolver {
	
	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		AbstractUrlBasedView view = super.buildView(viewName);
		String devPrefix = System.getProperty("openmrs-web.developmentPath");
		if (devPrefix == null || !viewName.startsWith("module"))
			return view;
		Module module = ModuleUtil.getModuleForPath(viewName.substring(viewName.indexOf('/') + 1));
		if (module != null && System.getProperty("openmrs-web.development." + module.getModuleId()) != null)
			view.setUrl(devPrefix + viewName + getSuffix());
		return view;
	}
}
