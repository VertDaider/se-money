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

import ru.serioussem.se.money.exception.NoSuchSubCategoryException;
import ru.serioussem.se.money.model.SubCategory;
import ru.serioussem.se.money.service.SubCategoryLocalServiceUtil;
import ru.serioussem.se.money.service.persistence.SubCategoryPersistence;
import ru.serioussem.se.money.service.persistence.SubCategoryUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class SubCategoryPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "ru.serioussem.se.money.service"));

	@Before
	public void setUp() {
		_persistence = SubCategoryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SubCategory> iterator = _subCategories.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SubCategory subCategory = _persistence.create(pk);

		Assert.assertNotNull(subCategory);

		Assert.assertEquals(subCategory.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SubCategory newSubCategory = addSubCategory();

		_persistence.remove(newSubCategory);

		SubCategory existingSubCategory = _persistence.fetchByPrimaryKey(
			newSubCategory.getPrimaryKey());

		Assert.assertNull(existingSubCategory);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSubCategory();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SubCategory newSubCategory = _persistence.create(pk);

		newSubCategory.setName(RandomTestUtil.randomString());

		newSubCategory.setParentCategoryId(RandomTestUtil.nextLong());

		_subCategories.add(_persistence.update(newSubCategory));

		SubCategory existingSubCategory = _persistence.findByPrimaryKey(
			newSubCategory.getPrimaryKey());

		Assert.assertEquals(
			existingSubCategory.getId(), newSubCategory.getId());
		Assert.assertEquals(
			existingSubCategory.getName(), newSubCategory.getName());
		Assert.assertEquals(
			existingSubCategory.getParentCategoryId(),
			newSubCategory.getParentCategoryId());
	}

	@Test
	public void testCountByParentCategoryId() throws Exception {
		_persistence.countByParentCategoryId(RandomTestUtil.nextLong());

		_persistence.countByParentCategoryId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SubCategory newSubCategory = addSubCategory();

		SubCategory existingSubCategory = _persistence.findByPrimaryKey(
			newSubCategory.getPrimaryKey());

		Assert.assertEquals(existingSubCategory, newSubCategory);
	}

	@Test(expected = NoSuchSubCategoryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SubCategory> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"se_money_SubCategory", "Id", true, "Name", true,
			"ParentCategoryId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SubCategory newSubCategory = addSubCategory();

		SubCategory existingSubCategory = _persistence.fetchByPrimaryKey(
			newSubCategory.getPrimaryKey());

		Assert.assertEquals(existingSubCategory, newSubCategory);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SubCategory missingSubCategory = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSubCategory);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SubCategory newSubCategory1 = addSubCategory();
		SubCategory newSubCategory2 = addSubCategory();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubCategory1.getPrimaryKey());
		primaryKeys.add(newSubCategory2.getPrimaryKey());

		Map<Serializable, SubCategory> subCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, subCategories.size());
		Assert.assertEquals(
			newSubCategory1,
			subCategories.get(newSubCategory1.getPrimaryKey()));
		Assert.assertEquals(
			newSubCategory2,
			subCategories.get(newSubCategory2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SubCategory> subCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(subCategories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SubCategory newSubCategory = addSubCategory();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubCategory.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SubCategory> subCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, subCategories.size());
		Assert.assertEquals(
			newSubCategory, subCategories.get(newSubCategory.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SubCategory> subCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(subCategories.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SubCategory newSubCategory = addSubCategory();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubCategory.getPrimaryKey());

		Map<Serializable, SubCategory> subCategories =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, subCategories.size());
		Assert.assertEquals(
			newSubCategory, subCategories.get(newSubCategory.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SubCategoryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SubCategory>() {

				@Override
				public void performAction(SubCategory subCategory) {
					Assert.assertNotNull(subCategory);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SubCategory newSubCategory = addSubCategory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SubCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("Id", newSubCategory.getId()));

		List<SubCategory> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		SubCategory existingSubCategory = result.get(0);

		Assert.assertEquals(existingSubCategory, newSubCategory);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SubCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("Id", RandomTestUtil.nextLong()));

		List<SubCategory> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SubCategory newSubCategory = addSubCategory();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SubCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		Object newId = newSubCategory.getId();

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
			SubCategory.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("Id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"Id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected SubCategory addSubCategory() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SubCategory subCategory = _persistence.create(pk);

		subCategory.setName(RandomTestUtil.randomString());

		subCategory.setParentCategoryId(RandomTestUtil.nextLong());

		_subCategories.add(_persistence.update(subCategory));

		return subCategory;
	}

	private List<SubCategory> _subCategories = new ArrayList<SubCategory>();
	private SubCategoryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}