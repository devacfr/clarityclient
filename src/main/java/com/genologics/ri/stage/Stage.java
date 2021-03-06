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

package com.genologics.ri.stage;

import java.io.Serializable;
import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.genologics.ri.GenologicsEntity;
import com.genologics.ri.Linkable;
import com.genologics.ri.protocolconfiguration.Protocol;
import com.genologics.ri.stepconfiguration.ProtocolStep;
import com.genologics.ri.workflowconfiguration.Workflow;

/**
 *
 * The detailed representation of a stage.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stage", propOrder = { "workflow", "protocol", "step" })
@XmlRootElement(name = "stage")
@GenologicsEntity(uriSection = "stages")
public class Stage implements Linkable<Stage>, Serializable
{
    private static final long serialVersionUID = -7190421220331989537L;

    @XmlElement(name = "workflow")
    protected WorkflowLink workflow;

    @XmlElement(name = "protocol")
    protected ProtocolLink protocol;

    @XmlElement(name = "step")
    protected ProtocolStepLink step;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    @XmlAttribute(name = "name")
    protected String name;

    @XmlAttribute(name = "index")
    protected Integer index;

    public Stage()
    {
    }

    public Stage(URI uri)
    {
        this.uri = uri;
    }

    public Stage(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    public WorkflowLink getWorkflow()
    {
        return workflow;
    }

    public void setWorkflow(Linkable<Workflow> workflow)
    {
        this.workflow = new WorkflowLink(workflow);
    }

    public ProtocolLink getProtocol()
    {
        return protocol;
    }

    public void setProtocol(Linkable<Protocol> protocol)
    {
        this.protocol = new ProtocolLink(protocol);
    }

    public ProtocolStepLink getStep()
    {
        return step;
    }

    public void setStep(Linkable<ProtocolStep> step)
    {
        this.step = new ProtocolStepLink(step);
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

    public Integer getIndex()
    {
        return index;
    }

    public void setIndex(Integer index)
    {
        this.index = index;
    }

}
