/*
 * CRUK-CI Genologics REST API Java Client.
 * Copyright (C) 2015 Cancer Research UK Cambridge Institute.
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

package com.genologics.ri.artifact;

import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * Provides links to workflow stages, stage names and their respective statuses.
 *
 * @since 2.20
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workflow-stage")
public class WorkflowStage implements Serializable
{
    private static final long serialVersionUID = 8029803456211993608L;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    @XmlAttribute(name = "name")
    protected String name;

    @XmlAttribute(name = "status")
    protected Status status;


    public WorkflowStage()
    {
    }

    public WorkflowStage(URI uri)
    {
        setUri(uri);
    }

    public WorkflowStage(URI uri, String name)
    {
        setUri(uri);
        setName(name);
    }

    public WorkflowStage(URI uri, String name, Status status)
    {
        setUri(uri);
        setName(name);
        setStatus(status);
    }

    public URI getUri()
    {
        return uri;
    }

    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

}
