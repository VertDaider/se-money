package ru.serioussem.se.money.portlet;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Reference;
import ru.serioussem.se.money.constants.BudgetPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import ru.serioussem.se.money.model.Account;
import ru.serioussem.se.money.service.AccountLocalService;
import ru.serioussem.se.money.service.AccountLocalServiceUtil;

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
    static final Log log = LogFactoryUtil.getLog(BudgetPortlet.class);
    @Reference
    private CounterLocalService counterLocalService;

    public void createAccount(ActionRequest request, ActionResponse response) {
        String name = ParamUtil.getString(request,"name", StringPool.BLANK);
        String balanceRow = ParamUtil.getString(request, "balance", StringPool.BLANK);
        boolean total = ParamUtil.getBoolean(request, "total", true);

        double balance;
        try {
            balance = Double.parseDouble(balanceRow);
        } catch (NumberFormatException e) {
            String[] arrNum = balanceRow.split(",");
            balance = Double.parseDouble(arrNum[0]) + Double.parseDouble("0." + arrNum[1]);
        }

        if (!Validator.isBlank(name) && balance != 0) {
            Account account = AccountLocalServiceUtil.createAccount(counterLocalService.increment(Account.class.getName()));
            account.setName(name);
            account.setBalance(balance);
            account.setTotal(total);
            AccountLocalServiceUtil.addAccount(account);
        }

    }
}