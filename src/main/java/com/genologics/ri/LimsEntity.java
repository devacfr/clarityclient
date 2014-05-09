/*
 * CRUK-CI Genologics REST API Java Client.
 * Copyright (C) 2013 Cancer Research UK Cambridge Institute.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.genologics.ri;

/**
 * Interface for all LIMS objects that have been assigned a LIMS identifier.
 *
 * @param <E> The type of the entity implementing this interface (a self reference).
 */
public interface LimsEntity<E extends LimsEntity<E>> extends LimsEntityLinkable<E>
{
    /**
     * Set the LIMS if for this object.
     *
     * @param id The new LIMS id.
     */
    void setLimsid(String id);
}
