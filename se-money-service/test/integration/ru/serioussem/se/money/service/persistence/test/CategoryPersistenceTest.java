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

import ru.serioussem.se.money.exception.NoSuchCategoryException;
import ru.serioussem.se.money.model.Category;
import ru.serioussem.se.money.service.CategoryLocalServiceUtil;
import ru.serioussem.se.money.service.persistence.CategoryPersistence;
import ru.serioussem.se.money.service.persistence.CategoryUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class CategoryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "ru.serioussem.se.money.service"));

	@Before
	public void setUp() {
		_persistence = CategoryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Category> iterator = _categories.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Category category = _persistence.create(pk);

		Assert.assertNotNull(category);

		Assert.assertEquals(category.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Category newCategory = addCategory();

		_persistence.remove(newCategory);

		Category existingCategory = _persistence.fetchByPrimaryKey(
			newCategory.getPrimaryKey());

		Assert.assertNull(existingCategory);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCategory();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Category newCategory = _persistence.create(pk);

		newCategory.setName(RandomTestUtil.randomString());

		newCategory.setType(RandomTestUtil.nextInt());

		_categories.add(_persistence.update(newCategory));

		Category existingCategory = _persistence.findByPrimaryKey(
			newCategory.getPrimaryKey());

		Assert.assertEquals(existingCategory.getId(), newCategory.getId());
		Assert.assertEquals(existingCategory.getName(), newCategory.getName());
		Assert.assertEquals(existingCategory.getType(), newCategory.getType());
	}

	@Test
	public void testCountByType() throws Exception {
		_persistence.countByType(RandomTestUtil.nextInt());

		_persistence.countByType(0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Category newCategory = addCategory();

		Category existingCategory = _persistence.findByPrimaryKey(
			newCategory.getPrimaryKey());

		Assert.assertEquals(existingCategory, newCategory);
	}

	@Test(expected = NoSuchCategoryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Category> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"se_money_Category", "Id", true, "Name", true, "Type", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Category newCategory = addCategory();

		Category existingCategory = _persistence.fetchByPrimaryKey(
			newCategory.getPrimaryKey());

		Assert.assertEquals(existingCategory, newCategory);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Category missingCategory = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCategory);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Category newCategory1 = addCategory();
		Category newCategory2 = addCategory();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCategory1.getPrimaryKey());
		primaryKeys.add(newCategory2.getPrimaryKey());

		Map<Serializable, Category> categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, categories.size());
		Assert.assertEquals(
			newCategory1, categories.get(newCategory1.getPrimaryKey()));
		Assert.assertEquals(
			newCategory2, categories.get(newCategory2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Category> categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(categories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Category newCategory = addCategory();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCategory.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Category> categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, categories.size());
		Assert.assertEquals(
			newCategory, categories.get(newCategory.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Category> categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(categories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Category newCategory = addCategory();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCategory.getPrimaryKey());

		Map<Serializable, Category> categories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, categories.size());
		Assert.assertEquals(
			newCategory, categories.get(newCategory.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CategoryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Category>() {

				@Override
				public void performAction(Category category) {
					Assert.assertNotNull(category);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Category newCategory = addCategory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Category.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("Id", newCategory.getId()));

		List<Category> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Category existingCategory = result.get(0);

		Assert.assertEquals(existingCategory, newCategory);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Category.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("Id", RandomTestUtil.nextLong()));

		List<Category> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Category newCategory = addCategory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Category.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		Object newId = newCategory.getId();

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
			Category.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"Id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Category addCategory() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Category category = _persistence.create(pk);

		category.setName(RandomTestUtil.randomString());

		category.setType(RandomTestUtil.nextInt());

		_categories.add(_persistence.update(category));

		return category;
	}

	private List<Category> _categories = new ArrayList<Category>();
	private CategoryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}