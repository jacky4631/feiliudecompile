// 
// Decompiled by Procyon v0.5.30
// 

package com.jiam365.flow.server.engine.route;

import com.jiam365.flow.server.engine.ChooseRestrict;
import com.jiam365.flow.server.dto.ChoosedProduct;
import com.jiam365.flow.sdk.RechargeRequest;

public interface Condition
{
    boolean pass(final RechargeRequest p0, final ChoosedProduct p1, final ChooseRestrict... p2);
}
