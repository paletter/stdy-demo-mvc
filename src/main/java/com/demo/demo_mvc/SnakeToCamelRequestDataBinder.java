package com.demo.demo_mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.web.servlet.mvc.method.annotation.ExtendedServletRequestDataBinder;

import com.google.common.base.CaseFormat;

public class SnakeToCamelRequestDataBinder extends ExtendedServletRequestDataBinder {

	public SnakeToCamelRequestDataBinder(Object target) {
		super(target);
	}

	@Override
	protected void addBindValues(MutablePropertyValues arg0, ServletRequest arg1) {
		super.addBindValues(arg0, arg1);
		
		List<PropertyValue> camelPVList = new ArrayList<PropertyValue>();
		arg0.getPropertyValueList().forEach(pv -> {
			if (pv.getName().contains("_")) {
				String camel = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, pv.getName());
				camelPVList.add(new PropertyValue(camel, pv.getValue()));
			}
		});
		
		arg0.getPropertyValueList().addAll(camelPVList);
	}
	
}
