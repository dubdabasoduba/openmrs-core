/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.module.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.Module;
import org.openmrs.module.ModuleUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class DevelopmentModuleResourcesServlet extends ModuleResourcesServlet {
	
	private static final long serialVersionUID = 1239820102030345L;
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Override
	protected File getFile(HttpServletRequest request) {
		
		String path = request.getPathInfo();
		
		Module module = ModuleUtil.getModuleForPath(path);
		if (module == null) {
			log.warn("No module handles the path: " + path);
			return null;
		}
		
		String relativePath = ModuleUtil.getPathForResource(module, path);
		String MODULE_PATH = "/WEB-INF/view/module/";
		String devPrefix = System.getProperty("openmrs-web.developmentPath");
		if (devPrefix != null) {
			log.info("Using custom prefix for file: " + devPrefix);
			
			if (System.getProperty("openmrs-web.development." + module.getModuleId()) != null)
				MODULE_PATH = devPrefix + "module/";
		}
		String realPath = getServletContext().getRealPath("") + MODULE_PATH + module.getModuleIdAsPath() + "/resources"
		        + relativePath;
		realPath = realPath.replace("/", File.separator);
		
		File f = new File(realPath);
		if (!f.exists()) {
			log.warn("No file with path '" + realPath + "' exists for module '" + module.getModuleId() + "'");
			return null;
		}
		
		return f;
	}
	
}
