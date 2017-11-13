package com.skilldistillery.lions.controllers;

import javax.validation.constraints.NotNull;

/**
 * Form with an Id Field.
 * @author gregory
 *
 */
public class LionIdForm {
	@NotNull
	private Integer id;
	
	public LionIdForm() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

}
