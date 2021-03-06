/**
 * ***************************************************************************
 * Copyright (c) 2018 RiceFish Limited
 * Project: SmartMES
 * Version: 1.6
 *
 * This file is part of SmartMES.
 *
 * SmartMES is Authorized software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation; either version 3 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * ***************************************************************************
 */
package com.qcadoo.mes.orders.constants;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.qcadoo.model.api.Entity;

public enum OrderType {

    WITH_PATTERN_TECHNOLOGY("01withPatternTechnology"), WITH_OWN_TECHNOLOGY("02withOwnTechnology"), OTHER("other");

    private final String state;

    private OrderType(final String state) {
        this.state = state;
    }

    public String getStringValue() {
        return state;
    }

    public static OrderType of(final Entity orderEntity) {
        Preconditions.checkArgument(orderEntity != null, "Missing entity");
        return parseString(orderEntity.getStringField(OrderFields.ORDER_TYPE));
    }

    public static OrderType parseString(final String rawOrderType) {
        String orderType = StringUtils.trim(rawOrderType);
        for (OrderType type : values()) {
            if (StringUtils.equalsIgnoreCase(type.getStringValue(), orderType)) {
                return type;
            }
        }

        return OTHER;
    }

}
