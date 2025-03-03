/*
 *  Copyright (C) <2022> <XiaoMoMi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.momirealms.customnameplates.object.placeholders;

import net.momirealms.customnameplates.object.ConditionalText;
import net.momirealms.customnameplates.object.requirements.Requirement;
import org.bukkit.entity.Player;

public class ConditionalTexts {

    private final ConditionalText[] conditionalTexts;

    public ConditionalTexts(ConditionalText[] conditionalTexts) {
        this.conditionalTexts = conditionalTexts;
    }

    public String getValue(Player player) {
        outer:
            for (ConditionalText conditionalText : conditionalTexts) {
                for (Requirement requirement : conditionalText.requirements()) {
                    if (!requirement.isConditionMet(player)) {
                        continue outer;
                    }
                }
                return conditionalText.text();
            }
            return "";
    }
}
