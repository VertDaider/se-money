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

import ru.serioussem.se.money.model.Category;

/**
 * The cache model class for representing Category in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CategoryCacheModel
	implements CacheModel<Category>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CategoryCacheModel)) {
			return false;
		}

		CategoryCacheModel categoryCacheModel = (CategoryCacheModel)object;

		if (Id == categoryCacheModel.Id) {
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
		sb.append(", Type=");
		sb.append(Type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Category toEntityModel() {
		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setId(Id);

		if (Name == null) {
			categoryImpl.setName("");
		}
		else {
			categoryImpl.setName(Name);
		}

		categoryImpl.setType(Type);

		categoryImpl.resetOriginalValues();

		return categoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Id = objectInput.readLong();
		Name = objectInput.readUTF();

		Type = objectInput.readInt();
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

		objectOutput.writeInt(Type);
	}

	public long Id;
	public String Name;
	public int Type;

}