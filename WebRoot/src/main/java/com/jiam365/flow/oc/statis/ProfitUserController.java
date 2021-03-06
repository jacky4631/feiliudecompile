// 
// Decompiled by Procyon v0.5.30
// 

package com.jiam365.flow.oc.statis;

import com.jiam365.flow.server.dto.TProfitByUser;
import java.util.List;
import java.util.Date;
import com.jiam365.modules.utils.SimpleDateUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.ui.Model;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import com.jiam365.flow.server.service.statis.StatisticsManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/oc/statis" })
public class ProfitUserController
{
    @Autowired
    private StatisticsManager statisticsManager;
    
    @RequiresRoles(value = { "financial", "admin" }, logical = Logical.OR)
    @RequestMapping({ "profit-user" })
    public String profitUser() {
        return "oc/statis/profit-user";
    }
    
    @RequiresRoles(value = { "financial", "admin" }, logical = Logical.OR)
    @RequestMapping({ "profit-user-content" })
    public String profitUserContent(final Model model, final String startDate, final String endDate) {
        try {
            final Date d1 = SimpleDateUtils.getDateStart(DateUtils.parseDate(startDate, new String[] { "yyyy-MM-dd" }));
            final Date d2 = SimpleDateUtils.getDateEnd(DateUtils.parseDate(endDate, new String[] { "yyyy-MM-dd" }));
            final List<TProfitByUser> profitByUsers = this.statisticsManager.getUserCostProfit(d1, d2);
            model.addAttribute("profitByUsers", (Object)profitByUsers);
        }
        catch (Exception ex) {}
        return "oc/statis/profit-user-content";
    }
}
