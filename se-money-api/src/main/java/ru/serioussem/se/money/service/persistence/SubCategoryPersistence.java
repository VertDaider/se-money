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

package ru.serioussem.se.money.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import ru.serioussem.se.money.exception.NoSuchSubCategoryException;
import ru.serioussem.se.money.model.SubCategory;

/**
 * The persistence interface for the sub category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubCategoryUtil
 * @generated
 */
@ProviderType
public interface SubCategoryPersistence extends BasePersistence<SubCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubCategoryUtil} to access the sub category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sub categories where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @return the matching sub categories
	 */
	public java.util.List<SubCategory> findByParentCategoryId(
		long ParentCategoryId);

	/**
	 * Returns a range of all the sub categories where ParentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param start the lower bound of the range of sub categories
	 * @param end the upper bound of the range of sub categories (not inclusive)
	 * @return the range of matching sub categories
	 */
	public java.util.List<SubCategory> findByParentCategoryId(
		long ParentCategoryId, int start, int end);

	/**
	 * Returns an ordered range of all the sub categories where ParentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param start the lower bound of the range of sub categories
	 * @param end the upper bound of the range of sub categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sub categories
	 */
	public java.util.List<SubCategory> findByParentCategoryId(
		long ParentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sub categories where ParentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param start the lower bound of the range of sub categories
	 * @param end the upper bound of the range of sub categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sub categories
	 */
	public java.util.List<SubCategory> findByParentCategoryId(
		long ParentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub category
	 * @throws NoSuchSubCategoryException if a matching sub category could not be found
	 */
	public SubCategory findByParentCategoryId_First(
			long ParentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<SubCategory>
				orderByComparator)
		throws NoSuchSubCategoryException;

	/**
	 * Returns the first sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub category, or <code>null</code> if a matching sub category could not be found
	 */
	public SubCategory fetchByParentCategoryId_First(
		long ParentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<SubCategory>
			orderByComparator);

	/**
	 * Returns the last sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub category
	 * @throws NoSuchSubCategoryException if a matching sub category could not be found
	 */
	public SubCategory findByParentCategoryId_Last(
			long ParentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<SubCategory>
				orderByComparator)
		throws NoSuchSubCategoryException;

	/**
	 * Returns the last sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub category, or <code>null</code> if a matching sub category could not be found
	 */
	public SubCategory fetchByParentCategoryId_Last(
		long ParentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<SubCategory>
			orderByComparator);

	/**
	 * Returns the sub categories before and after the current sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param Id the primary key of the current sub category
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub category
	 * @throws NoSuchSubCategoryException if a sub category with the primary key could not be found
	 */
	public SubCategory[] findByParentCategoryId_PrevAndNext(
			long Id, long ParentCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<SubCategory>
				orderByComparator)
		throws NoSuchSubCategoryException;

	/**
	 * Removes all the sub categories where ParentCategoryId = &#63; from the database.
	 *
	 * @param ParentCategoryId the parent category ID
	 */
	public void removeByParentCategoryId(long ParentCategoryId);

	/**
	 * Returns the number of sub categories where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @return the number of matching sub categories
	 */
	public int countByParentCategoryId(long ParentCategoryId);

	/**
	 * Caches the sub category in the entity cache if it is enabled.
	 *
	 * @param subCategory the sub category
	 */
	public void cacheResult(SubCategory subCategory);

	/**
	 * Caches the sub categories in the entity cache if it is enabled.
	 *
	 * @param subCategories the sub categories
	 */
	public void cacheResult(java.util.List<SubCategory> subCategories);

	/**
	 * Creates a new sub category with the primary key. Does not add the sub category to the database.
	 *
	 * @param Id the primary key for the new sub category
	 * @return the new sub category
	 */
	public SubCategory create(long Id);

	/**
	 * Removes the sub category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the sub category
	 * @return the sub category that was removed
	 * @throws NoSuchSubCategoryException if a sub category with the primary key could not be found
	 */
	public SubCategory remove(long Id) throws NoSuchSubCategoryException;

	public SubCategory updateImpl(SubCategory subCategory);

	/**
	 * Returns the sub category with the primary key or throws a <code>NoSuchSubCategoryException</code> if it could not be found.
	 *
	 * @param Id the primary key of the sub category
	 * @return the sub category
	 * @throws NoSuchSubCategoryException if a sub category with the primary key could not be found
	 */
	public SubCategory findByPrimaryKey(long Id)
		throws NoSuchSubCategoryException;

	/**
	 * Returns the sub category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the sub category
	 * @return the sub category, or <code>null</code> if a sub category with the primary key could not be found
	 */
	public SubCategory fetchByPrimaryKey(long Id);

	/**
	 * Returns all the sub categories.
	 *
	 * @return the sub categories
	 */
	public java.util.List<SubCategory> findAll();

	/**
	 * Returns a range of all the sub categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub categories
	 * @param end the upper bound of the range of sub categories (not inclusive)
	 * @return the range of sub categories
	 */
	public java.util.List<SubCategory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sub categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub categories
	 * @param end the upper bound of the range of sub categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sub categories
	 */
	public java.util.List<SubCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubCategory>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sub categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub categories
	 * @param end the upper bound of the range of sub categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sub categories
	 */
	public java.util.List<SubCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sub categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sub categories.
	 *
	 * @return the number of sub categories
	 */
	public int countAll();

}