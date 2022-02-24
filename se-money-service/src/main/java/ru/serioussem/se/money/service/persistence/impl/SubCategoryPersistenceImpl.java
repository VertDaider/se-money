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

package ru.serioussem.se.money.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import ru.serioussem.se.money.exception.NoSuchSubCategoryException;
import ru.serioussem.se.money.model.SubCategory;
import ru.serioussem.se.money.model.impl.SubCategoryImpl;
import ru.serioussem.se.money.model.impl.SubCategoryModelImpl;
import ru.serioussem.se.money.service.persistence.SubCategoryPersistence;
import ru.serioussem.se.money.service.persistence.SubCategoryUtil;
import ru.serioussem.se.money.service.persistence.impl.constants.se_moneyPersistenceConstants;

/**
 * The persistence implementation for the sub category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SubCategoryPersistence.class)
public class SubCategoryPersistenceImpl
	extends BasePersistenceImpl<SubCategory> implements SubCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SubCategoryUtil</code> to access the sub category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SubCategoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByParentCategoryId;
	private FinderPath _finderPathWithoutPaginationFindByParentCategoryId;
	private FinderPath _finderPathCountByParentCategoryId;

	/**
	 * Returns all the sub categories where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @return the matching sub categories
	 */
	@Override
	public List<SubCategory> findByParentCategoryId(long ParentCategoryId) {
		return findByParentCategoryId(
			ParentCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SubCategory> findByParentCategoryId(
		long ParentCategoryId, int start, int end) {

		return findByParentCategoryId(ParentCategoryId, start, end, null);
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
	@Override
	public List<SubCategory> findByParentCategoryId(
		long ParentCategoryId, int start, int end,
		OrderByComparator<SubCategory> orderByComparator) {

		return findByParentCategoryId(
			ParentCategoryId, start, end, orderByComparator, true);
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
	@Override
	public List<SubCategory> findByParentCategoryId(
		long ParentCategoryId, int start, int end,
		OrderByComparator<SubCategory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParentCategoryId;
				finderArgs = new Object[] {ParentCategoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParentCategoryId;
			finderArgs = new Object[] {
				ParentCategoryId, start, end, orderByComparator
			};
		}

		List<SubCategory> list = null;

		if (useFinderCache) {
			list = (List<SubCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SubCategory subCategory : list) {
					if (ParentCategoryId != subCategory.getParentCategoryId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SUBCATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_PARENTCATEGORYID_PARENTCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SubCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ParentCategoryId);

				list = (List<SubCategory>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub category
	 * @throws NoSuchSubCategoryException if a matching sub category could not be found
	 */
	@Override
	public SubCategory findByParentCategoryId_First(
			long ParentCategoryId,
			OrderByComparator<SubCategory> orderByComparator)
		throws NoSuchSubCategoryException {

		SubCategory subCategory = fetchByParentCategoryId_First(
			ParentCategoryId, orderByComparator);

		if (subCategory != null) {
			return subCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ParentCategoryId=");
		sb.append(ParentCategoryId);

		sb.append("}");

		throw new NoSuchSubCategoryException(sb.toString());
	}

	/**
	 * Returns the first sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub category, or <code>null</code> if a matching sub category could not be found
	 */
	@Override
	public SubCategory fetchByParentCategoryId_First(
		long ParentCategoryId,
		OrderByComparator<SubCategory> orderByComparator) {

		List<SubCategory> list = findByParentCategoryId(
			ParentCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub category
	 * @throws NoSuchSubCategoryException if a matching sub category could not be found
	 */
	@Override
	public SubCategory findByParentCategoryId_Last(
			long ParentCategoryId,
			OrderByComparator<SubCategory> orderByComparator)
		throws NoSuchSubCategoryException {

		SubCategory subCategory = fetchByParentCategoryId_Last(
			ParentCategoryId, orderByComparator);

		if (subCategory != null) {
			return subCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ParentCategoryId=");
		sb.append(ParentCategoryId);

		sb.append("}");

		throw new NoSuchSubCategoryException(sb.toString());
	}

	/**
	 * Returns the last sub category in the ordered set where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub category, or <code>null</code> if a matching sub category could not be found
	 */
	@Override
	public SubCategory fetchByParentCategoryId_Last(
		long ParentCategoryId,
		OrderByComparator<SubCategory> orderByComparator) {

		int count = countByParentCategoryId(ParentCategoryId);

		if (count == 0) {
			return null;
		}

		List<SubCategory> list = findByParentCategoryId(
			ParentCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SubCategory[] findByParentCategoryId_PrevAndNext(
			long Id, long ParentCategoryId,
			OrderByComparator<SubCategory> orderByComparator)
		throws NoSuchSubCategoryException {

		SubCategory subCategory = findByPrimaryKey(Id);

		Session session = null;

		try {
			session = openSession();

			SubCategory[] array = new SubCategoryImpl[3];

			array[0] = getByParentCategoryId_PrevAndNext(
				session, subCategory, ParentCategoryId, orderByComparator,
				true);

			array[1] = subCategory;

			array[2] = getByParentCategoryId_PrevAndNext(
				session, subCategory, ParentCategoryId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubCategory getByParentCategoryId_PrevAndNext(
		Session session, SubCategory subCategory, long ParentCategoryId,
		OrderByComparator<SubCategory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SUBCATEGORY_WHERE);

		sb.append(_FINDER_COLUMN_PARENTCATEGORYID_PARENTCATEGORYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SubCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(ParentCategoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(subCategory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SubCategory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sub categories where ParentCategoryId = &#63; from the database.
	 *
	 * @param ParentCategoryId the parent category ID
	 */
	@Override
	public void removeByParentCategoryId(long ParentCategoryId) {
		for (SubCategory subCategory :
				findByParentCategoryId(
					ParentCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(subCategory);
		}
	}

	/**
	 * Returns the number of sub categories where ParentCategoryId = &#63;.
	 *
	 * @param ParentCategoryId the parent category ID
	 * @return the number of matching sub categories
	 */
	@Override
	public int countByParentCategoryId(long ParentCategoryId) {
		FinderPath finderPath = _finderPathCountByParentCategoryId;

		Object[] finderArgs = new Object[] {ParentCategoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SUBCATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_PARENTCATEGORYID_PARENTCATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ParentCategoryId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_PARENTCATEGORYID_PARENTCATEGORYID_2 =
			"subCategory.ParentCategoryId = ?";

	public SubCategoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("Id", "id_");
		dbColumnNames.put("Name", "name");
		dbColumnNames.put("ParentCategoryId", "parent_category_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(SubCategory.class);

		setModelImplClass(SubCategoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the sub category in the entity cache if it is enabled.
	 *
	 * @param subCategory the sub category
	 */
	@Override
	public void cacheResult(SubCategory subCategory) {
		entityCache.putResult(
			SubCategoryImpl.class, subCategory.getPrimaryKey(), subCategory);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sub categories in the entity cache if it is enabled.
	 *
	 * @param subCategories the sub categories
	 */
	@Override
	public void cacheResult(List<SubCategory> subCategories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (subCategories.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SubCategory subCategory : subCategories) {
			if (entityCache.getResult(
					SubCategoryImpl.class, subCategory.getPrimaryKey()) ==
						null) {

				cacheResult(subCategory);
			}
		}
	}

	/**
	 * Clears the cache for all sub categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sub category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubCategory subCategory) {
		entityCache.removeResult(SubCategoryImpl.class, subCategory);
	}

	@Override
	public void clearCache(List<SubCategory> subCategories) {
		for (SubCategory subCategory : subCategories) {
			entityCache.removeResult(SubCategoryImpl.class, subCategory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SubCategoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sub category with the primary key. Does not add the sub category to the database.
	 *
	 * @param Id the primary key for the new sub category
	 * @return the new sub category
	 */
	@Override
	public SubCategory create(long Id) {
		SubCategory subCategory = new SubCategoryImpl();

		subCategory.setNew(true);
		subCategory.setPrimaryKey(Id);

		return subCategory;
	}

	/**
	 * Removes the sub category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the sub category
	 * @return the sub category that was removed
	 * @throws NoSuchSubCategoryException if a sub category with the primary key could not be found
	 */
	@Override
	public SubCategory remove(long Id) throws NoSuchSubCategoryException {
		return remove((Serializable)Id);
	}

	/**
	 * Removes the sub category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sub category
	 * @return the sub category that was removed
	 * @throws NoSuchSubCategoryException if a sub category with the primary key could not be found
	 */
	@Override
	public SubCategory remove(Serializable primaryKey)
		throws NoSuchSubCategoryException {

		Session session = null;

		try {
			session = openSession();

			SubCategory subCategory = (SubCategory)session.get(
				SubCategoryImpl.class, primaryKey);

			if (subCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(subCategory);
		}
		catch (NoSuchSubCategoryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SubCategory removeImpl(SubCategory subCategory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subCategory)) {
				subCategory = (SubCategory)session.get(
					SubCategoryImpl.class, subCategory.getPrimaryKeyObj());
			}

			if (subCategory != null) {
				session.delete(subCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (subCategory != null) {
			clearCache(subCategory);
		}

		return subCategory;
	}

	@Override
	public SubCategory updateImpl(SubCategory subCategory) {
		boolean isNew = subCategory.isNew();

		if (!(subCategory instanceof SubCategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(subCategory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(subCategory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in subCategory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SubCategory implementation " +
					subCategory.getClass());
		}

		SubCategoryModelImpl subCategoryModelImpl =
			(SubCategoryModelImpl)subCategory;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(subCategory);
			}
			else {
				subCategory = (SubCategory)session.merge(subCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SubCategoryImpl.class, subCategoryModelImpl, false, true);

		if (isNew) {
			subCategory.setNew(false);
		}

		subCategory.resetOriginalValues();

		return subCategory;
	}

	/**
	 * Returns the sub category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sub category
	 * @return the sub category
	 * @throws NoSuchSubCategoryException if a sub category with the primary key could not be found
	 */
	@Override
	public SubCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubCategoryException {

		SubCategory subCategory = fetchByPrimaryKey(primaryKey);

		if (subCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return subCategory;
	}

	/**
	 * Returns the sub category with the primary key or throws a <code>NoSuchSubCategoryException</code> if it could not be found.
	 *
	 * @param Id the primary key of the sub category
	 * @return the sub category
	 * @throws NoSuchSubCategoryException if a sub category with the primary key could not be found
	 */
	@Override
	public SubCategory findByPrimaryKey(long Id)
		throws NoSuchSubCategoryException {

		return findByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns the sub category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the sub category
	 * @return the sub category, or <code>null</code> if a sub category with the primary key could not be found
	 */
	@Override
	public SubCategory fetchByPrimaryKey(long Id) {
		return fetchByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns all the sub categories.
	 *
	 * @return the sub categories
	 */
	@Override
	public List<SubCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SubCategory> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<SubCategory> findAll(
		int start, int end, OrderByComparator<SubCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<SubCategory> findAll(
		int start, int end, OrderByComparator<SubCategory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<SubCategory> list = null;

		if (useFinderCache) {
			list = (List<SubCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SUBCATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SUBCATEGORY;

				sql = sql.concat(SubCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SubCategory>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sub categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SubCategory subCategory : findAll()) {
			remove(subCategory);
		}
	}

	/**
	 * Returns the number of sub categories.
	 *
	 * @return the number of sub categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SUBCATEGORY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUBCATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SubCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sub category persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new SubCategoryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SubCategory.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByParentCategoryId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentCategoryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"parent_category_id"}, true);

		_finderPathWithoutPaginationFindByParentCategoryId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentCategoryId",
			new String[] {Long.class.getName()},
			new String[] {"parent_category_id"}, true);

		_finderPathCountByParentCategoryId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentCategoryId", new String[] {Long.class.getName()},
			new String[] {"parent_category_id"}, false);

		_setSubCategoryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSubCategoryUtilPersistence(null);

		entityCache.removeCache(SubCategoryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setSubCategoryUtilPersistence(
		SubCategoryPersistence subCategoryPersistence) {

		try {
			Field field = SubCategoryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, subCategoryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = se_moneyPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = se_moneyPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = se_moneyPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SUBCATEGORY =
		"SELECT subCategory FROM SubCategory subCategory";

	private static final String _SQL_SELECT_SUBCATEGORY_WHERE =
		"SELECT subCategory FROM SubCategory subCategory WHERE ";

	private static final String _SQL_COUNT_SUBCATEGORY =
		"SELECT COUNT(subCategory) FROM SubCategory subCategory";

	private static final String _SQL_COUNT_SUBCATEGORY_WHERE =
		"SELECT COUNT(subCategory) FROM SubCategory subCategory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "subCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SubCategory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SubCategory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SubCategoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"Id", "Name", "ParentCategoryId"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class SubCategoryModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			SubCategoryModelImpl subCategoryModelImpl =
				(SubCategoryModelImpl)baseModel;

			long columnBitmask = subCategoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(subCategoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						subCategoryModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(SubCategoryPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(subCategoryModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			SubCategoryModelImpl subCategoryModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = subCategoryModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = subCategoryModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= SubCategoryModelImpl.getColumnBitmask(
				"name");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}