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

package com.genologics.ri.stepconfiguration;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * A field has a name and an attach to value, these fields are used to keep
 * track of all the UDF values for samples in queue and work view as well as
 * those on the actual step
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "field")
@XmlSeeAlso({ QueueField.class })
public class Field implements Serializable
{
    private static final long serialVersionUID = 1689876520646016314L;

    @XmlAttribute(name = "name")
    protected String name;

    @XmlAttribute(name = "attach-to")
    protected String attachTo;

    public Field()
    {
    }

    public Field(String name)
    {
        this.name = name;
    }

    public Field(String name, String attachTo)
    {
        this.name = name;
        this.attachTo = attachTo;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAttachTo()
    {
        return attachTo;
    }

    public void setAttachTo(String attachTo)
    {
        this.attachTo = attachTo;
    }

}
