package com.cts.adv.annotations;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnotationsInterpreter {
	Map<String, List<String>> authorFields = new HashMap<>();

	public void inject(Class<Employee> employeeClass) {
		Field[] fields = employeeClass.getFields();
		for (Field field : fields) {
			System.out.println(field.getName());
			Author annotation = field.getAnnotation(Author.class);
			System.out.println(annotation.name());
			System.out.println(annotation.email());
			System.out.println(annotation.type());

			if (authorFields.get(annotation.name()) != null) {
				List<String> list = authorFields.get(annotation.name());
				list.add(field.getName());
			} else {
				List<String> newList = new ArrayList<>();
				newList.add(field.getName());
				authorFields.put(annotation.name(), newList);
			}

			// field.getAnnotation(Author.class).;

		}
		System.out.println(authorFields);

	}

}
