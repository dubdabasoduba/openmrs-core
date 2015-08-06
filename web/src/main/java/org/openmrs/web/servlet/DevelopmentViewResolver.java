/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.web.servlet;

import java.util.regex.Pattern;

import org.openmrs.module.Module;
import org.openmrs.module.ModuleUtil;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class DevelopmentViewResolver extends InternalResourceViewResolver {

	private static Pattern viewNamePattern = Pattern.compile("/?module.*");

	@Override
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		AbstractUrlBasedView view = super.buildView(viewName);
		String devPrefix = System.getProperty("openmrs-web.developmentPath");
		if (devPrefix == null || !viewNamePattern.matcher(viewName).find())
			return view;
		Module module = ModuleUtil.getModuleForPath(viewName.substring(viewName.indexOf('/', 1) + 1));
		if (module != null && System.getProperty("openmrs-web.development." + module.getModuleId()) != null)
			view.setUrl(devPrefix + viewName + getSuffix());
		return view;
	}
}
