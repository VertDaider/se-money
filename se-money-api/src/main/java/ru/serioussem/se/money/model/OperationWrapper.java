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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Operation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Operation
 * @generated
 */
public class OperationWrapper
	extends BaseModelWrapper<Operation>
	implements ModelWrapper<Operation>, Operation {

	public OperationWrapper(Operation operation) {
		super(operation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("Date", getDate());
		attributes.put("CategoryId", getCategoryId());
		attributes.put("Sum", getSum());
		attributes.put("Comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		Date Date = (Date)attributes.get("Date");

		if (Date != null) {
			setDate(Date);
		}

		Long CategoryId = (Long)attributes.get("CategoryId");

		if (CategoryId != null) {
			setCategoryId(CategoryId);
		}

		Double Sum = (Double)attributes.get("Sum");

		if (Sum != null) {
			setSum(Sum);
		}

		String Comment = (String)attributes.get("Comment");

		if (Comment != null) {
			setComment(Comment);
		}
	}

	/**
	 * Returns the category ID of this operation.
	 *
	 * @return the category ID of this operation
	 */
	@Override
	public long getCategoryId() {
		return model.getCategoryId();
	}

	/**
	 * Returns the comment of this operation.
	 *
	 * @return the comment of this operation
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the date of this operation.
	 *
	 * @return the date of this operation
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the ID of this operation.
	 *
	 * @return the ID of this operation
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this operation.
	 *
	 * @return the primary key of this operation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sum of this operation.
	 *
	 * @return the sum of this operation
	 */
	@Override
	public double getSum() {
		return model.getSum();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the category ID of this operation.
	 *
	 * @param CategoryId the category ID of this operation
	 */
	@Override
	public void setCategoryId(long CategoryId) {
		model.setCategoryId(CategoryId);
	}

	/**
	 * Sets the comment of this operation.
	 *
	 * @param Comment the comment of this operation
	 */
	@Override
	public void setComment(String Comment) {
		model.setComment(Comment);
	}

	/**
	 * Sets the date of this operation.
	 *
	 * @param Date the date of this operation
	 */
	@Override
	public void setDate(Date Date) {
		model.setDate(Date);
	}

	/**
	 * Sets the ID of this operation.
	 *
	 * @param Id the ID of this operation
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the primary key of this operation.
	 *
	 * @param primaryKey the primary key of this operation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sum of this operation.
	 *
	 * @param Sum the sum of this operation
	 */
	@Override
	public void setSum(double Sum) {
		model.setSum(Sum);
	}

	@Override
	protected OperationWrapper wrap(Operation operation) {
		return new OperationWrapper(operation);
	}

}