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

import ru.serioussem.se.money.model.Account;

/**
 * The persistence utility for the account service. This utility wraps <code>ru.serioussem.se.money.service.persistence.impl.AccountPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountPersistence
 * @generated
 */
public class AccountUtil {

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
	public static void clearCache(Account account) {
		getPersistence().clearCache(account);
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
	public static Map<Serializable, Account> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Account> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Account> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Account> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Account> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Account update(Account account) {
		return getPersistence().update(account);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Account update(
		Account account, ServiceContext serviceContext) {

		return getPersistence().update(account, serviceContext);
	}

	/**
	 * Caches the account in the entity cache if it is enabled.
	 *
	 * @param account the account
	 */
	public static void cacheResult(Account account) {
		getPersistence().cacheResult(account);
	}

	/**
	 * Caches the accounts in the entity cache if it is enabled.
	 *
	 * @param accounts the accounts
	 */
	public static void cacheResult(List<Account> accounts) {
		getPersistence().cacheResult(accounts);
	}

	/**
	 * Creates a new account with the primary key. Does not add the account to the database.
	 *
	 * @param Id the primary key for the new account
	 * @return the new account
	 */
	public static Account create(long Id) {
		return getPersistence().create(Id);
	}

	/**
	 * Removes the account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the account
	 * @return the account that was removed
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account remove(long Id)
		throws ru.serioussem.se.money.exception.NoSuchAccountException {

		return getPersistence().remove(Id);
	}

	public static Account updateImpl(Account account) {
		return getPersistence().updateImpl(account);
	}

	/**
	 * Returns the account with the primary key or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param Id the primary key of the account
	 * @return the account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public static Account findByPrimaryKey(long Id)
		throws ru.serioussem.se.money.exception.NoSuchAccountException {

		return getPersistence().findByPrimaryKey(Id);
	}

	/**
	 * Returns the account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the account
	 * @return the account, or <code>null</code> if a account with the primary key could not be found
	 */
	public static Account fetchByPrimaryKey(long Id) {
		return getPersistence().fetchByPrimaryKey(Id);
	}

	/**
	 * Returns all the accounts.
	 *
	 * @return the accounts
	 */
	public static List<Account> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of accounts
	 */
	public static List<Account> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of accounts
	 */
	public static List<Account> findAll(
		int start, int end, OrderByComparator<Account> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of accounts
	 */
	public static List<Account> findAll(
		int start, int end, OrderByComparator<Account> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the accounts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of accounts.
	 *
	 * @return the number of accounts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AccountPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AccountPersistence _persistence;

}