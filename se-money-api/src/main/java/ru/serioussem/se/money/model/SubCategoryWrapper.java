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
 * This class is a wrapper for {@link SubCategory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubCategory
 * @generated
 */
public class SubCategoryWrapper
	extends BaseModelWrapper<SubCategory>
	implements ModelWrapper<SubCategory>, SubCategory {

	public SubCategoryWrapper(SubCategory subCategory) {
		super(subCategory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("Name", getName());
		attributes.put("ParentCategoryId", getParentCategoryId());

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

		Long ParentCategoryId = (Long)attributes.get("ParentCategoryId");

		if (ParentCategoryId != null) {
			setParentCategoryId(ParentCategoryId);
		}
	}

	/**
	 * Returns the ID of this sub category.
	 *
	 * @return the ID of this sub category
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this sub category.
	 *
	 * @return the name of this sub category
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent category ID of this sub category.
	 *
	 * @return the parent category ID of this sub category
	 */
	@Override
	public long getParentCategoryId() {
		return model.getParentCategoryId();
	}

	/**
	 * Returns the primary key of this sub category.
	 *
	 * @return the primary key of this sub category
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this sub category.
	 *
	 * @param Id the ID of this sub category
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the name of this sub category.
	 *
	 * @param Name the name of this sub category
	 */
	@Override
	public void setName(String Name) {
		model.setName(Name);
	}

	/**
	 * Sets the parent category ID of this sub category.
	 *
	 * @param ParentCategoryId the parent category ID of this sub category
	 */
	@Override
	public void setParentCategoryId(long ParentCategoryId) {
		model.setParentCategoryId(ParentCategoryId);
	}

	/**
	 * Sets the primary key of this sub category.
	 *
	 * @param primaryKey the primary key of this sub category
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected SubCategoryWrapper wrap(SubCategory subCategory) {
		return new SubCategoryWrapper(subCategory);
	}

}