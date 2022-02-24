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

package ru.serioussem.se.money.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import ru.serioussem.se.money.model.Account;

/**
 * The cache model class for representing Account in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AccountCacheModel implements CacheModel<Account>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AccountCacheModel)) {
			return false;
		}

		AccountCacheModel accountCacheModel = (AccountCacheModel)object;

		if (Id == accountCacheModel.Id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, Id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{Id=");
		sb.append(Id);
		sb.append(", Name=");
		sb.append(Name);
		sb.append(", Balance=");
		sb.append(Balance);
		sb.append(", Total=");
		sb.append(Total);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Account toEntityModel() {
		AccountImpl accountImpl = new AccountImpl();

		accountImpl.setId(Id);

		if (Name == null) {
			accountImpl.setName("");
		}
		else {
			accountImpl.setName(Name);
		}

		accountImpl.setBalance(Balance);
		accountImpl.setTotal(Total);

		accountImpl.resetOriginalValues();

		return accountImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Id = objectInput.readLong();
		Name = objectInput.readUTF();

		Balance = objectInput.readDouble();

		Total = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(Id);

		if (Name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Name);
		}

		objectOutput.writeDouble(Balance);

		objectOutput.writeBoolean(Total);
	}

	public long Id;
	public String Name;
	public double Balance;
	public boolean Total;

}