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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class OperationSoap implements Serializable {

	public static OperationSoap toSoapModel(Operation model) {
		OperationSoap soapModel = new OperationSoap();

		soapModel.setId(model.getId());
		soapModel.setDate(model.getDate());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setSum(model.getSum());
		soapModel.setComment(model.getComment());

		return soapModel;
	}

	public static OperationSoap[] toSoapModels(Operation[] models) {
		OperationSoap[] soapModels = new OperationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OperationSoap[][] toSoapModels(Operation[][] models) {
		OperationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OperationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OperationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OperationSoap[] toSoapModels(List<Operation> models) {
		List<OperationSoap> soapModels = new ArrayList<OperationSoap>(
			models.size());

		for (Operation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OperationSoap[soapModels.size()]);
	}

	public OperationSoap() {
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

	public Date getDate() {
		return _Date;
	}

	public void setDate(Date Date) {
		_Date = Date;
	}

	public long getCategoryId() {
		return _CategoryId;
	}

	public void setCategoryId(long CategoryId) {
		_CategoryId = CategoryId;
	}

	public double getSum() {
		return _Sum;
	}

	public void setSum(double Sum) {
		_Sum = Sum;
	}

	public String getComment() {
		return _Comment;
	}

	public void setComment(String Comment) {
		_Comment = Comment;
	}

	private long _Id;
	private Date _Date;
	private long _CategoryId;
	private double _Sum;
	private String _Comment;

}