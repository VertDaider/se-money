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

import ru.serioussem.se.money.exception.NoSuchOperationException;
import ru.serioussem.se.money.model.Operation;

/**
 * The persistence interface for the operation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OperationUtil
 * @generated
 */
@ProviderType
public interface OperationPersistence extends BasePersistence<Operation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OperationUtil} to access the operation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the operations where CategoryId = &#63;.
	 *
	 * @param CategoryId the category ID
	 * @return the matching operations
	 */
	public java.util.List<Operation> findByCategoryId(long CategoryId);

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
	public java.util.List<Operation> findByCategoryId(
		long CategoryId, int start, int end);

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
	public java.util.List<Operation> findByCategoryId(
		long CategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator);

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
	public java.util.List<Operation> findByCategoryId(
		long CategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first operation in the ordered set where CategoryId = &#63;.
	 *
	 * @param CategoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public Operation findByCategoryId_First(
			long CategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Operation>
				orderByComparator)
		throws NoSuchOperationException;

	/**
	 * Returns the first operation in the ordered set where CategoryId = &#63;.
	 *
	 * @param CategoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public Operation fetchByCategoryId_First(
		long CategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator);

	/**
	 * Returns the last operation in the ordered set where CategoryId = &#63;.
	 *
	 * @param CategoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	public Operation findByCategoryId_Last(
			long CategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Operation>
				orderByComparator)
		throws NoSuchOperationException;

	/**
	 * Returns the last operation in the ordered set where CategoryId = &#63;.
	 *
	 * @param CategoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation, or <code>null</code> if a matching operation could not be found
	 */
	public Operation fetchByCategoryId_Last(
		long CategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator);

	/**
	 * Returns the operations before and after the current operation in the ordered set where CategoryId = &#63;.
	 *
	 * @param Id the primary key of the current operation
	 * @param CategoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public Operation[] findByCategoryId_PrevAndNext(
			long Id, long CategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<Operation>
				orderByComparator)
		throws NoSuchOperationException;

	/**
	 * Removes all the operations where CategoryId = &#63; from the database.
	 *
	 * @param CategoryId the category ID
	 */
	public void removeByCategoryId(long CategoryId);

	/**
	 * Returns the number of operations where CategoryId = &#63;.
	 *
	 * @param CategoryId the category ID
	 * @return the number of matching operations
	 */
	public int countByCategoryId(long CategoryId);

	/**
	 * Caches the operation in the entity cache if it is enabled.
	 *
	 * @param operation the operation
	 */
	public void cacheResult(Operation operation);

	/**
	 * Caches the operations in the entity cache if it is enabled.
	 *
	 * @param operations the operations
	 */
	public void cacheResult(java.util.List<Operation> operations);

	/**
	 * Creates a new operation with the primary key. Does not add the operation to the database.
	 *
	 * @param Id the primary key for the new operation
	 * @return the new operation
	 */
	public Operation create(long Id);

	/**
	 * Removes the operation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the operation
	 * @return the operation that was removed
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public Operation remove(long Id) throws NoSuchOperationException;

	public Operation updateImpl(Operation operation);

	/**
	 * Returns the operation with the primary key or throws a <code>NoSuchOperationException</code> if it could not be found.
	 *
	 * @param Id the primary key of the operation
	 * @return the operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	public Operation findByPrimaryKey(long Id) throws NoSuchOperationException;

	/**
	 * Returns the operation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the operation
	 * @return the operation, or <code>null</code> if a operation with the primary key could not be found
	 */
	public Operation fetchByPrimaryKey(long Id);

	/**
	 * Returns all the operations.
	 *
	 * @return the operations
	 */
	public java.util.List<Operation> findAll();

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
	public java.util.List<Operation> findAll(int start, int end);

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
	public java.util.List<Operation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator);

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
	public java.util.List<Operation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Operation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the operations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of operations.
	 *
	 * @return the number of operations
	 */
	public int countAll();

}