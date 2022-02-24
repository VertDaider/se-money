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

import ru.serioussem.se.money.model.SubCategory;

/**
 * The cache model class for representing SubCategory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubCategoryCacheModel
	implements CacheModel<SubCategory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubCategoryCacheModel)) {
			return false;
		}

		SubCategoryCacheModel subCategoryCacheModel =
			(SubCategoryCacheModel)object;

		if (Id == subCategoryCacheModel.Id) {
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
		StringBundler sb = new StringBundler(7);

		sb.append("{Id=");
		sb.append(Id);
		sb.append(", Name=");
		sb.append(Name);
		sb.append(", ParentCategoryId=");
		sb.append(ParentCategoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SubCategory toEntityModel() {
		SubCategoryImpl subCategoryImpl = new SubCategoryImpl();

		subCategoryImpl.setId(Id);

		if (Name == null) {
			subCategoryImpl.setName("");
		}
		else {
			subCategoryImpl.setName(Name);
		}

		subCategoryImpl.setParentCategoryId(ParentCategoryId);

		subCategoryImpl.resetOriginalValues();

		return subCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Id = objectInput.readLong();
		Name = objectInput.readUTF();

		ParentCategoryId = objectInput.readLong();
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

		objectOutput.writeLong(ParentCategoryId);
	}

	public long Id;
	public String Name;
	public long ParentCategoryId;

}