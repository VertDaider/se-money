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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Category service. Represents a row in the &quot;se_money_Category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>ru.serioussem.se.money.model.impl.CategoryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>ru.serioussem.se.money.model.impl.CategoryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Category
 * @generated
 */
@ProviderType
public interface CategoryModel extends BaseModel<Category> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a category model instance should use the {@link Category} interface instead.
	 */

	/**
	 * Returns the primary key of this category.
	 *
	 * @return the primary key of this category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this category.
	 *
	 * @param primaryKey the primary key of this category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this category.
	 *
	 * @return the ID of this category
	 */
	public long getId();

	/**
	 * Sets the ID of this category.
	 *
	 * @param Id the ID of this category
	 */
	public void setId(long Id);

	/**
	 * Returns the name of this category.
	 *
	 * @return the name of this category
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this category.
	 *
	 * @param Name the name of this category
	 */
	public void setName(String Name);

	/**
	 * Returns the type of this category.
	 *
	 * @return the type of this category
	 */
	public int getType();

	/**
	 * Sets the type of this category.
	 *
	 * @param Type the type of this category
	 */
	public void setType(int Type);

}