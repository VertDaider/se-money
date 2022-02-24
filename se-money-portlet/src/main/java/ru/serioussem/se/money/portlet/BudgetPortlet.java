package ru.serioussem.se.money.portlet;

import ru.serioussem.se.money.constants.BudgetPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author dovgopolov
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=" + BudgetPortletKeys.DISPLAY_NAME,
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=" + BudgetPortletKeys.MAIN_JSP,
                "javax.portlet.name=" + BudgetPortletKeys.BUDGET,
                "com.liferay.portlet.header-portlet-javascript=/js/main.js",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "javax.portlet.version=3.0"
        },
        service = Portlet.class
)
public class BudgetPortlet extends MVCPortlet {
}