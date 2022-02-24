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

import java.util.Date;

import ru.serioussem.se.money.model.Operation;

/**
 * The cache model class for representing Operation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OperationCacheModel
	implements CacheModel<Operation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OperationCacheModel)) {
			return false;
		}

		OperationCacheModel operationCacheModel = (OperationCacheModel)object;

		if (Id == operationCacheModel.Id) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{Id=");
		sb.append(Id);
		sb.append(", Date=");
		sb.append(Date);
		sb.append(", CategoryId=");
		sb.append(CategoryId);
		sb.append(", Sum=");
		sb.append(Sum);
		sb.append(", Comment=");
		sb.append(Comment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Operation toEntityModel() {
		OperationImpl operationImpl = new OperationImpl();

		operationImpl.setId(Id);

		if (Date == Long.MIN_VALUE) {
			operationImpl.setDate(null);
		}
		else {
			operationImpl.setDate(new Date(Date));
		}

		operationImpl.setCategoryId(CategoryId);
		operationImpl.setSum(Sum);

		if (Comment == null) {
			operationImpl.setComment("");
		}
		else {
			operationImpl.setComment(Comment);
		}

		operationImpl.resetOriginalValues();

		return operationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Id = objectInput.readLong();
		Date = objectInput.readLong();

		CategoryId = objectInput.readLong();

		Sum = objectInput.readDouble();
		Comment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(Id);
		objectOutput.writeLong(Date);

		objectOutput.writeLong(CategoryId);

		objectOutput.writeDouble(Sum);

		if (Comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Comment);
		}
	}

	public long Id;
	public long Date;
	public long CategoryId;
	public double Sum;
	public String Comment;

}