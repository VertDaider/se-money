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
import com.liferay.portal.kernel.util.Time;
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

import ru.serioussem.se.money.exception.NoSuchOperationException;
import ru.serioussem.se.money.model.Operation;
import ru.serioussem.se.money.service.OperationLocalServiceUtil;
import ru.serioussem.se.money.service.persistence.OperationPersistence;
import ru.serioussem.se.money.service.persistence.OperationUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class OperationPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "ru.serioussem.se.money.service"));

	@Before
	public void setUp() {
		_persistence = OperationUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Operation> iterator = _operations.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Operation operation = _persistence.create(pk);

		Assert.assertNotNull(operation);

		Assert.assertEquals(operation.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Operation newOperation = addOperation();

		_persistence.remove(newOperation);

		Operation existingOperation = _persistence.fetchByPrimaryKey(
			newOperation.getPrimaryKey());

		Assert.assertNull(existingOperation);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addOperation();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Operation newOperation = _persistence.create(pk);

		newOperation.setDate(RandomTestUtil.nextDate());

		newOperation.setCategoryId(RandomTestUtil.nextLong());

		newOperation.setSum(RandomTestUtil.nextDouble());

		newOperation.setComment(RandomTestUtil.randomString());

		_operations.add(_persistence.update(newOperation));

		Operation existingOperation = _persistence.findByPrimaryKey(
			newOperation.getPrimaryKey());

		Assert.assertEquals(existingOperation.getId(), newOperation.getId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingOperation.getDate()),
			Time.getShortTimestamp(newOperation.getDate()));
		Assert.assertEquals(
			existingOperation.getCategoryId(), newOperation.getCategoryId());
		AssertUtils.assertEquals(
			existingOperation.getSum(), newOperation.getSum());
		Assert.assertEquals(
			existingOperation.getComment(), newOperation.getComment());
	}

	@Test
	public void testCountByCategoryId() throws Exception {
		_persistence.countByCategoryId(RandomTestUtil.nextLong());

		_persistence.countByCategoryId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Operation newOperation = addOperation();

		Operation existingOperation = _persistence.findByPrimaryKey(
			newOperation.getPrimaryKey());

		Assert.assertEquals(existingOperation, newOperation);
	}

	@Test(expected = NoSuchOperationException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Operation> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"se_money_Operation", "Id", true, "Date", true, "CategoryId", true,
			"Sum", true, "Comment", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Operation newOperation = addOperation();

		Operation existingOperation = _persistence.fetchByPrimaryKey(
			newOperation.getPrimaryKey());

		Assert.assertEquals(existingOperation, newOperation);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Operation missingOperation = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingOperation);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Operation newOperation1 = addOperation();
		Operation newOperation2 = addOperation();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOperation1.getPrimaryKey());
		primaryKeys.add(newOperation2.getPrimaryKey());

		Map<Serializable, Operation> operations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, operations.size());
		Assert.assertEquals(
			newOperation1, operations.get(newOperation1.getPrimaryKey()));
		Assert.assertEquals(
			newOperation2, operations.get(newOperation2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Operation> operations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(operations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Operation newOperation = addOperation();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOperation.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Operation> operations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, operations.size());
		Assert.assertEquals(
			newOperation, operations.get(newOperation.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Operation> operations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(operations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Operation newOperation = addOperation();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOperation.getPrimaryKey());

		Map<Serializable, Operation> operations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, operations.size());
		Assert.assertEquals(
			newOperation, operations.get(newOperation.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			OperationLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Operation>() {

				@Override
				public void performAction(Operation operation) {
					Assert.assertNotNull(operation);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Operation newOperation = addOperation();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Operation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("Id", newOperation.getId()));

		List<Operation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Operation existingOperation = result.get(0);

		Assert.assertEquals(existingOperation, newOperation);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Operation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("Id", RandomTestUtil.nextLong()));

		List<Operation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Operation newOperation = addOperation();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Operation.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		Object newId = newOperation.getId();

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
			Operation.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"Id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Operation addOperation() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Operation operation = _persistence.create(pk);

		operation.setDate(RandomTestUtil.nextDate());

		operation.setCategoryId(RandomTestUtil.nextLong());

		operation.setSum(RandomTestUtil.nextDouble());

		operation.setComment(RandomTestUtil.randomString());

		_operations.add(_persistence.update(operation));

		return operation;
	}

	private List<Operation> _operations = new ArrayList<Operation>();
	private OperationPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}