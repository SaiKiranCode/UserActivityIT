package com.user.demo.model;

public class ActivityType extends Activity {

	private Long id;
	private String name;
	private Long point_value;
	private Boolean has_context;
	private String context;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPoint_value() {
		return point_value;
	}

	public void setPoint_value(Long point_value) {
		this.point_value = point_value;
	}

	public Boolean getHas_context() {
		return has_context;
	}

	public void setHas_context(Boolean has_context) {
		this.has_context = has_context;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
