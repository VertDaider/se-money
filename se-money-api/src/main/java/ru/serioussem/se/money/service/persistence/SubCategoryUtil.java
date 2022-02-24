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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import ru.serioussem.se.money.model.SubCategory;

/**
 * The persistence utility for the sub category service. This utility wraps <code>ru.serioussem.se.money.service.persistence.impl.SubCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubCategoryPersistence
 * @generated
 */
public class SubCategoryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SubCategory subCategory) {
		getPersistence().clearCache(subCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, SubCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SubCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SubCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SubCategory update(SubCategory subCategory) {
		return getPersistence().update(subCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SubCategory update(
		SubCategory subCategory, ServiceContext serviceContext) {

		return getPersistence().update(subCategory, serviceContext);
	}

	/**
	 * Returns all the sub categories where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @return the matching sub categories
	 */
	public static List<SubCategory> findByParentCategoryId(
		long ParentCategoryId) {

		return getPersistence().findByParentCategoryId(ParentCategoryId);
	}

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
	public static List<SubCategory> findByParentCategoryId(
		long ParentCategoryId, int start, int end) {

		return getPersistence().findByParentCategoryId(
			ParentCategoryId, start, end);
	}

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
	public static List<SubCategory> findByParentCategoryId(
		long ParentCategoryId, int start, int end,
		OrderByComparator<SubCategory> orderByComparator) {

		return getPersistence().findByParentCategoryId(
			ParentCategoryId, start, end, orderByComparator);
	}

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
	public static List<SubCategory> findByParentCategoryId(
		long ParentCategoryId, int start, int end,
		OrderByComparator<SubCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentCategoryId(
			ParentCategoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub category
	 * @throws NoSuchSubCategoryException if a matching sub category could not be found
	 */
	public static SubCategory findByParentCategoryId_First(
			long ParentCategoryId,
			OrderByComparator<SubCategory> orderByComparator)
		throws ru.serioussem.se.money.exception.NoSuchSubCategoryException {

		return getPersistence().findByParentCategoryId_First(
			ParentCategoryId, orderByComparator);
	}

	/**
	 * Returns the first sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub category, or <code>null</code> if a matching sub category could not be found
	 */
	public static SubCategory fetchByParentCategoryId_First(
		long ParentCategoryId,
		OrderByComparator<SubCategory> orderByComparator) {

		return getPersistence().fetchByParentCategoryId_First(
			ParentCategoryId, orderByComparator);
	}

	/**
	 * Returns the last sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub category
	 * @throws NoSuchSubCategoryException if a matching sub category could not be found
	 */
	public static SubCategory findByParentCategoryId_Last(
			long ParentCategoryId,
			OrderByComparator<SubCategory> orderByComparator)
		throws ru.serioussem.se.money.exception.NoSuchSubCategoryException {

		return getPersistence().findByParentCategoryId_Last(
			ParentCategoryId, orderByComparator);
	}

	/**
	 * Returns the last sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub category, or <code>null</code> if a matching sub category could not be found
	 */
	public static SubCategory fetchByParentCategoryId_Last(
		long ParentCategoryId,
		OrderByComparator<SubCategory> orderByComparator) {

		return getPersistence().fetchByParentCategoryId_Last(
			ParentCategoryId, orderByComparator);
	}

	/**
	 * Returns the sub categories before and after the current sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param Id the primary key of the current sub category
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub category
	 * @throws NoSuchSubCategoryException if a sub category with the primary key could not be found
	 */
	public static SubCategory[] findByParentCategoryId_PrevAndNext(
			long Id, long ParentCategoryId,
			OrderByComparator<SubCategory> orderByComparator)
		throws ru.serioussem.se.money.exception.NoSuchSubCategoryException {

		return getPersistence().findByParentCategoryId_PrevAndNext(
			Id, ParentCategoryId, orderByComparator);
	}

	/**
	 * Removes all the sub categories where ParentCategoryId = &#63; from the database.
	 *
	 * @param ParentCategoryId the parent category ID
	 */
	public static void removeByParentCategoryId(long ParentCategoryId) {
		getPersistence().removeByParentCategoryId(ParentCategoryId);
	}

	/**
	 * Returns the number of sub categories where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @return the number of matching sub categories
	 */
	public static int countByParentCategoryId(long ParentCategoryId) {
		return getPersistence().countByParentCategoryId(ParentCategoryId);
	}

	/**
	 * Caches the sub category in the entity cache if it is enabled.
	 *
	 * @param subCategory the sub category
	 */
	public static void cacheResult(SubCategory subCategory) {
		getPersistence().cacheResult(subCategory);
	}

	/**
	 * Caches the sub categories in the entity cache if it is enabled.
	 *
	 * @param subCategories the sub categories
	 */
	public static void cacheResult(List<SubCategory> subCategories) {
		getPersistence().cacheResult(subCategories);
	}

	/**
	 * Creates a new sub category with the primary key. Does not add the sub category to the database.
	 *
	 * @param Id the primary key for the new sub category
	 * @return the new sub category
	 */
	public static SubCategory create(long Id) {
		return getPersistence().create(Id);
	}

	/**
	 * Removes the sub category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the sub category
	 * @return the sub category that was removed
	 * @throws NoSuchSubCategoryException if a sub category with the primary key could not be found
	 */
	public static SubCategory remove(long Id)
		throws ru.serioussem.se.money.exception.NoSuchSubCategoryException {

		return getPersistence().remove(Id);
	}

	public static SubCategory updateImpl(SubCategory subCategory) {
		return getPersistence().updateImpl(subCategory);
	}

	/**
	 * Returns the sub category with the primary key or throws a <code>NoSuchSubCategoryException</code> if it could not be found.
	 *
	 * @param Id the primary key of the sub category
	 * @return the sub category
	 * @throws NoSuchSubCategoryException if a sub category with the primary key could not be found
	 */
	public static SubCategory findByPrimaryKey(long Id)
		throws ru.serioussem.se.money.exception.NoSuchSubCategoryException {

		return getPersistence().findByPrimaryKey(Id);
	}

	/**
	 * Returns the sub category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the sub category
	 * @return the sub category, or <code>null</code> if a sub category with the primary key could not be found
	 */
	public static SubCategory fetchByPrimaryKey(long Id) {
		return getPersistence().fetchByPrimaryKey(Id);
	}

	/**
	 * Returns all the sub categories.
	 *
	 * @return the sub categories
	 */
	public static List<SubCategory> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<SubCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<SubCategory> findAll(
		int start, int end, OrderByComparator<SubCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<SubCategory> findAll(
		int start, int end, OrderByComparator<SubCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sub categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sub categories.
	 *
	 * @return the number of sub categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SubCategoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SubCategoryPersistence _persistence;

}