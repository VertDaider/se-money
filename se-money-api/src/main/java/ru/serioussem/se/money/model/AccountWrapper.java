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
 * This class is a wrapper for {@link Account}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Account
 * @generated
 */
public class AccountWrapper
	extends BaseModelWrapper<Account>
	implements Account, ModelWrapper<Account> {

	public AccountWrapper(Account account) {
		super(account);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("Name", getName());
		attributes.put("Balance", getBalance());
		attributes.put("Total", isTotal());

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

		Double Balance = (Double)attributes.get("Balance");

		if (Balance != null) {
			setBalance(Balance);
		}

		Boolean Total = (Boolean)attributes.get("Total");

		if (Total != null) {
			setTotal(Total);
		}
	}

	/**
	 * Returns the balance of this account.
	 *
	 * @return the balance of this account
	 */
	@Override
	public double getBalance() {
		return model.getBalance();
	}

	/**
	 * Returns the ID of this account.
	 *
	 * @return the ID of this account
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this account.
	 *
	 * @return the name of this account
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this account.
	 *
	 * @return the primary key of this account
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the total of this account.
	 *
	 * @return the total of this account
	 */
	@Override
	public boolean getTotal() {
		return model.getTotal();
	}

	/**
	 * Returns <code>true</code> if this account is total.
	 *
	 * @return <code>true</code> if this account is total; <code>false</code> otherwise
	 */
	@Override
	public boolean isTotal() {
		return model.isTotal();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the balance of this account.
	 *
	 * @param Balance the balance of this account
	 */
	@Override
	public void setBalance(double Balance) {
		model.setBalance(Balance);
	}

	/**
	 * Sets the ID of this account.
	 *
	 * @param Id the ID of this account
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the name of this account.
	 *
	 * @param Name the name of this account
	 */
	@Override
	public void setName(String Name) {
		model.setName(Name);
	}

	/**
	 * Sets the primary key of this account.
	 *
	 * @param primaryKey the primary key of this account
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this account is total.
	 *
	 * @param Total the total of this account
	 */
	@Override
	public void setTotal(boolean Total) {
		model.setTotal(Total);
	}

	@Override
	protected AccountWrapper wrap(Account account) {
		return new AccountWrapper(account);
	}

}