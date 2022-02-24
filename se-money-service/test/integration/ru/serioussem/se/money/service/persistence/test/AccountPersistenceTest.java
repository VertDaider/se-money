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

package ru.serioussem.se.money.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AssertUtils;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.serioussem.se.money.exception.NoSuchAccountException;
import ru.serioussem.se.money.model.Account;
import ru.serioussem.se.money.service.AccountLocalServiceUtil;
import ru.serioussem.se.money.service.persistence.AccountPersistence;
import ru.serioussem.se.money.service.persistence.AccountUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AccountPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "ru.serioussem.se.money.service"));

	@Before
	public void setUp() {
		_persistence = AccountUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Account> iterator = _accounts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Account account = _persistence.create(pk);

		Assert.assertNotNull(account);

		Assert.assertEquals(account.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Account newAccount = addAccount();

		_persistence.remove(newAccount);

		Account existingAccount = _persistence.fetchByPrimaryKey(
			newAccount.getPrimaryKey());

		Assert.assertNull(existingAccount);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAccount();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Account newAccount = _persistence.create(pk);

		newAccount.setName(RandomTestUtil.randomString());

		newAccount.setBalance(RandomTestUtil.nextDouble());

		newAccount.setTotal(RandomTestUtil.randomBoolean());

		_accounts.add(_persistence.update(newAccount));

		Account existingAccount = _persistence.findByPrimaryKey(
			newAccount.getPrimaryKey());

		Assert.assertEquals(existingAccount.getId(), newAccount.getId());
		Assert.assertEquals(existingAccount.getName(), newAccount.getName());
		AssertUtils.assertEquals(
			existingAccount.getBalance(), newAccount.getBalance());
		Assert.assertEquals(existingAccount.isTotal(), newAccount.isTotal());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Account newAccount = addAccount();

		Account existingAccount = _persistence.findByPrimaryKey(
			newAccount.getPrimaryKey());

		Assert.assertEquals(existingAccount, newAccount);
	}

	@Test(expected = NoSuchAccountException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Account> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"se_money_Account", "Id", true, "Name", true, "Balance", true,
			"Total", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Account newAccount = addAccount();

		Account existingAccount = _persistence.fetchByPrimaryKey(
			newAccount.getPrimaryKey());

		Assert.assertEquals(existingAccount, newAccount);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Account missingAccount = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAccount);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Account newAccount1 = addAccount();
		Account newAccount2 = addAccount();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAccount1.getPrimaryKey());
		primaryKeys.add(newAccount2.getPrimaryKey());

		Map<Serializable, Account> accounts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, accounts.size());
		Assert.assertEquals(
			newAccount1, accounts.get(newAccount1.getPrimaryKey()));
		Assert.assertEquals(
			newAccount2, accounts.get(newAccount2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Account> accounts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(accounts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Account newAccount = addAccount();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAccount.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Account> accounts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, accounts.size());
		Assert.assertEquals(
			newAccount, accounts.get(newAccount.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Account> accounts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(accounts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Account newAccount = addAccount();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAccount.getPrimaryKey());

		Map<Serializable, Account> accounts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, accounts.size());
		Assert.assertEquals(
			newAccount, accounts.get(newAccount.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AccountLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Account>() {

				@Override
				public void performAction(Account account) {
					Assert.assertNotNull(account);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Account newAccount = addAccount();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Account.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("Id", newAccount.getId()));

		List<Account> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Account existingAccount = result.get(0);

		Assert.assertEquals(existingAccount, newAccount);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Account.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("Id", RandomTestUtil.nextLong()));

		List<Account> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Account newAccount = addAccount();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Account.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		Object newId = newAccount.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("Id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Account.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"Id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Account addAccount() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Account account = _persistence.create(pk);

		account.setName(RandomTestUtil.randomString());

		account.setBalance(RandomTestUtil.nextDouble());

		account.setTotal(RandomTestUtil.randomBoolean());

		_accounts.add(_persistence.update(account));

		return account;
	}

	private List<Account> _accounts = new ArrayList<Account>();
	private AccountPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}