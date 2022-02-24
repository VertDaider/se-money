/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ru.serioussem.se.money.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Category
 * @generated
 */
public class CategoryWrapper
	extends BaseModelWrapper<Category>
	implements Category, ModelWrapper<Category> {

	public CategoryWrapper(Category category) {
		super(category);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("Name", getName());
		attributes.put("Type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		Integer Type = (Integer)attributes.get("Type");

		if (Type != null) {
			setType(Type);
		}
	}

	/**
	 * Returns the ID of this category.
	 *
	 * @return the ID of this category
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this category.
	 *
	 * @return the name of this category
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this category.
	 *
	 * @return the primary key of this category
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this category.
	 *
	 * @return the type of this category
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this category.
	 *
	 * @param Id the ID of this category
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the name of this category.
	 *
	 * @param Name the name of this category
	 */
	@Override
	public void setName(String Name) {
		model.setName(Name);
	}

	/**
	 * Sets the primary key of this category.
	 *
	 * @param primaryKey the primary key of this category
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this category.
	 *
	 * @param Type the type of this category
	 */
	@Override
	public void setType(int Type) {
		model.setType(Type);
	}

	@Override
	protected CategoryWrapper wrap(Category category) {
		return new CategoryWrapper(category);
	}

}