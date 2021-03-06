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

import ru.serioussem.se.money.model.Operation;

/**
 * The persistence utility for the operation service. This utility wraps <code>ru.serioussem.se.money.service.persistence.impl.OperationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OperationPersistence
 * @generated
 */
public class OperationUtil {

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
	public static void clearCache(Operation operation) {
		getPersistence().clearCache(operation);
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
	public static Map<Serializable, Operation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Operation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Operation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Operation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Operation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Operation update(Operation operation) {
		return getPersistence().update(operation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Operation update(
		Operation operation, ServiceContext serviceContext) {

		return getPersistence().update(operation, serviceContext);
	}

	/**
	 * Returns all the operations where CategoryId = &#63;.
	 *
	 * @param CategoryId the category ID
	 * @return the matching operations
	 */
	public static List<Operation> findByCategoryId(long CategoryId) {
		return getPersistence().findByCategoryId(CategoryId);
	}

	/**
	 * Returns a range of all the operations where CategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param CategoryId the category ID
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @return the range of matching operations
	 */
	public static List<Operation> findByCategoryId(
		long CategoryId, int start, int end) {

		return getPersistence().findByCategoryId(CategoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the operations where CategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param CategoryId the category ID
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching operations
	 */
	public static List<Operation> findByCategoryId(
		long CategoryId, int start, int end,
		OrderByComparator<Operation> orderByComparator) {

		return getPersistence().findByCategoryId(
			CategoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the operations where CategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param CategoryId the category ID
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching operations
	 */
	public static List<Operation> findByCategoryId(
		long CategoryId, int start, int end,
		OrderByComparator<Operation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCategoryId(
			CategoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first operation in the ordered set where CategoryId = &#63;.
	 *
	 * @param CategoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public static Operation findByCategoryId_First(
			long CategoryId, OrderByComparator<Operation> orderByComparator)
		throws ru.serioussem.se.money.exception.NoSuchOperationException {

		return getPersistence().findByCategoryId_First(
			CategoryId, orderByComparator);
	}

	/**
	 * Returns the first operation in the ordered set where CategoryId = &#63;.
	 *
	 * @param CategoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public static Operation fetchByCategoryId_First(
		long CategoryId, OrderByComparator<Operation> orderByComparator) {

		return getPersistence().fetchByCategoryId_First(
			CategoryId, orderByComparator);
	}

	/**
	 * Returns the last operation in the ordered set where CategoryId = &#63;.
	 *
	 * @param CategoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public static Operation findByCategoryId_Last(
			long CategoryId, OrderByComparator<Operation> orderByComparator)
		throws ru.serioussem.se.money.exception.NoSuchOperationException {

		return getPersistence().findByCategoryId_Last(
			CategoryId, orderByComparator);
	}

	/**
	 * Returns the last operation in the ordered set where CategoryId = &#63;.
	 *
	 * @param CategoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public static Operation fetchByCategoryId_Last(
		long CategoryId, OrderByComparator<Operation> orderByComparator) {

		return getPersistence().fetchByCategoryId_Last(
			CategoryId, orderByComparator);
	}

	/**
	 * Returns the operations before and after the current operation in the ordered set where CategoryId = &#63;.
	 *
	 * @param Id the primary key of the current operation
	 * @param CategoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public static Operation[] findByCategoryId_PrevAndNext(
			long Id, long CategoryId,
			OrderByComparator<Operation> orderByComparator)
		throws ru.serioussem.se.money.exception.NoSuchOperationException {

		return getPersistence().findByCategoryId_PrevAndNext(
			Id, CategoryId, orderByComparator);
	}

	/**
	 * Removes all the operations where CategoryId = &#63; from the database.
	 *
	 * @param CategoryId the category ID
	 */
	public static void removeByCategoryId(long CategoryId) {
		getPersistence().removeByCategoryId(CategoryId);
	}

	/**
	 * Returns the number of operations where CategoryId = &#63;.
	 *
	 * @param CategoryId the category ID
	 * @return the number of matching operations
	 */
	public static int countByCategoryId(long CategoryId) {
		return getPersistence().countByCategoryId(CategoryId);
	}

	/**
	 * Caches the operation in the entity cache if it is enabled.
	 *
	 * @param operation the operation
	 */
	public static void cacheResult(Operation operation) {
		getPersistence().cacheResult(operation);
	}

	/**
	 * Caches the operations in the entity cache if it is enabled.
	 *
	 * @param operations the operations
	 */
	public static void cacheResult(List<Operation> operations) {
		getPersistence().cacheResult(operations);
	}

	/**
	 * Creates a new operation with the primary key. Does not add the operation to the database.
	 *
	 * @param Id the primary key for the new operation
	 * @return the new operation
	 */
	public static Operation create(long Id) {
		return getPersistence().create(Id);
	}

	/**
	 * Removes the operation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the operation
	 * @return the operation that was removed
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public static Operation remove(long Id)
		throws ru.serioussem.se.money.exception.NoSuchOperationException {

		return getPersistence().remove(Id);
	}

	public static Operation updateImpl(Operation operation) {
		return getPersistence().updateImpl(operation);
	}

	/**
	 * Returns the operation with the primary key or throws a <code>NoSuchOperationException</code> if it could not be found.
	 *
	 * @param Id the primary key of the operation
	 * @return the operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public static Operation findByPrimaryKey(long Id)
		throws ru.serioussem.se.money.exception.NoSuchOperationException {

		return getPersistence().findByPrimaryKey(Id);
	}

	/**
	 * Returns the operation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the operation
	 * @return the operation, or <code>null</code> if a operation with the primary key could not be found
	 */
	public static Operation fetchByPrimaryKey(long Id) {
		return getPersistence().fetchByPrimaryKey(Id);
	}

	/**
	 * Returns all the operations.
	 *
	 * @return the operations
	 */
	public static List<Operation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the operations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @return the range of operations
	 */
	public static List<Operation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the operations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of operations
	 */
	public static List<Operation> findAll(
		int start, int end, OrderByComparator<Operation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the operations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of operations
	 */
	public static List<Operation> findAll(
		int start, int end, OrderByComparator<Operation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the operations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of operations.
	 *
	 * @return the number of operations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OperationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile OperationPersistence _persistence;

}