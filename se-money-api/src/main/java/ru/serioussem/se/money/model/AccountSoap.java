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
public class AccountSoap implements Serializable {

	public static AccountSoap toSoapModel(Account model) {
		AccountSoap soapModel = new AccountSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setBalance(model.getBalance());
		soapModel.setTotal(model.isTotal());

		return soapModel;
	}

	public static AccountSoap[] toSoapModels(Account[] models) {
		AccountSoap[] soapModels = new AccountSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AccountSoap[][] toSoapModels(Account[][] models) {
		AccountSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AccountSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AccountSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AccountSoap[] toSoapModels(List<Account> models) {
		List<AccountSoap> soapModels = new ArrayList<AccountSoap>(
			models.size());

		for (Account model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AccountSoap[soapModels.size()]);
	}

	public AccountSoap() {
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

	public double getBalance() {
		return _Balance;
	}

	public void setBalance(double Balance) {
		_Balance = Balance;
	}

	public boolean getTotal() {
		return _Total;
	}

	public boolean isTotal() {
		return _Total;
	}

	public void setTotal(boolean Total) {
		_Total = Total;
	}

	private long _Id;
	private String _Name;
	private double _Balance;
	private boolean _Total;

}