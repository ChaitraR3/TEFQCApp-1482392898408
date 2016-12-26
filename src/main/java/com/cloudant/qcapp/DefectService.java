package com.cloudant.qcapp;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

public class DefectService extends Application{

	public Set<Class<?>> getClasses() {

		Set<Class<?>> classes = new HashSet<Class<?>>();

		classes.add(DefectDetails.class);
		return classes;
	}

}


