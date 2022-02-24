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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CategorySoap implements Serializable {

	public static CategorySoap toSoapModel(Category model) {
		CategorySoap soapModel = new CategorySoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static CategorySoap[] toSoapModels(Category[] models) {
		CategorySoap[] soapModels = new CategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CategorySoap[][] toSoapModels(Category[][] models) {
		CategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CategorySoap[] toSoapModels(List<Category> models) {
		List<CategorySoap> soapModels = new ArrayList<CategorySoap>(
			models.size());

		for (Category model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CategorySoap[soapModels.size()]);
	}

	public CategorySoap() {
	}

	public long getPrimaryKey() {
		return _Id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _Id;
	}

	public void setId(long Id) {
		_Id = Id;
	}

	public String getName() {
		return _Name;
	}

	public void setName(String Name) {
		_Name = Name;
	}

	public int getType() {
		return _Type;
	}

	public void setType(int Type) {
		_Type = Type;
	}

	private long _Id;
	private String _Name;
	private int _Type;

}