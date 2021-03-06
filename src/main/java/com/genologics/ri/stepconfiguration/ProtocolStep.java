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
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.genologics.ri.Linkable;
import com.genologics.ri.containertype.ContainerType;
import com.genologics.ri.controltype.ControlType;
import com.genologics.ri.processtype.ProcessType;
import com.genologics.ri.reagentkit.ReagentKit;
import com.genologics.ri.reagenttype.ReagentType;

/**
 *
 * <p>
 * Detailed representation of a Step
 * </p>
 * <p>
 * Steps are the elements that compose protocols. They have various properties
 * regarding different UDFs contained on each view of the step as well as
 * configuration option and filters
 * </p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "step",
         propOrder = { "protocolStepIndex", "processType", "permittedContainerTypes", "permittedReagentCategories",
                       "requiredReagentKits", "permittedControlTypes", "transitions", "defaultGrouping", "queueFields",
                       "stepFields", "sampleFields", "stepProperties", "stepSetup", "eppTriggers" })
@XmlRootElement(name = "step")
public class ProtocolStep implements Linkable<ProtocolStep>, Serializable
{
    private static final long serialVersionUID = 496185986542798015L;

    @XmlElement(name = "protocol-step-index")
    protected Integer protocolStepIndex;

    @XmlElement(name = "process-type")
    protected ProcessTypeLink processType;

    @XmlElementWrapper(name = "permitted-containers")
    @XmlElement(name = "container-type")
    protected List<String> permittedContainerTypes;

    @XmlElementWrapper(name = "permitted-reagent-categories")
    @XmlElement(name = "reagent-category")
    protected List<String> permittedReagentCategories;

    /**
     * @since 2.18
     */
    @XmlElementWrapper(name = "required-reagent-kits")
    @XmlElement(name = "reagent-kit")
    protected List<ReagentKitLink> requiredReagentKits;

    @XmlElementWrapper(name = "permitted-control-types")
    @XmlElement(name = "control-type")
    protected List<ControlTypeLink> permittedControlTypes;

    @XmlElementWrapper(name = "transitions")
    @XmlElement(name = "transition")
    protected List<NextStep> transitions;

    /**
     * @since 2.18
     */
    @XmlElement(name = "default-grouping")
    protected String defaultGrouping;

    @XmlElementWrapper(name = "queue-fields")
    @XmlElement(name = "queue-field")
    protected List<QueueField> queueFields;

    @XmlElementWrapper(name = "step-fields")
    @XmlElement(name = "step-field")
    protected List<Field> stepFields;

    @XmlElementWrapper(name = "sample-fields")
    @XmlElement(name = "sample-field")
    protected List<Field> sampleFields;

    @XmlElementWrapper(name = "step-properties")
    @XmlElement(name = "step-property")
    protected List<StepProperty> stepProperties;

    @XmlElement(name = "step-setup")
    protected StepSetup stepSetup;

    @XmlElementWrapper(name = "epp-triggers")
    @XmlElement(name = "epp-trigger")
    protected List<EppTrigger> eppTriggers;

    @XmlAttribute(name = "name")
    protected String name;

    @XmlAttribute(name = "uri")
    @XmlSchemaType(name = "anyURI")
    protected URI uri;

    @XmlAttribute(name = "protocol-uri")
    @XmlSchemaType(name = "anyURI")
    protected URI protocolUri;

    public ProtocolStep()
    {
    }

    public ProtocolStep(URI uri)
    {
        this.uri = uri;
    }

    public ProtocolStep(URI uri, String name)
    {
        this.uri = uri;
        this.name = name;
    }

    public Integer getProtocolStepIndex()
    {
        return protocolStepIndex;
    }

    public void setProtocolStepIndex(Integer protocolStepIndex)
    {
        this.protocolStepIndex = protocolStepIndex;
    }

    public ProcessTypeLink getProcessType()
    {
        return processType;
    }

    public void setProcessType(Linkable<ProcessType> processType)
    {
        this.processType = new ProcessTypeLink(processType);
    }

    public List<String> getPermittedContainerTypes()
    {
        if (permittedContainerTypes == null)
        {
            permittedContainerTypes = new ArrayList<String>();
        }
        return permittedContainerTypes;
    }

    public String addPermittedContainer(String containerType)
    {
        getPermittedContainerTypes().add(containerType);
        return containerType;
    }

    public String addPermittedContainer(ContainerType type)
    {
        getPermittedContainerTypes().add(type.getName());
        return type.getName();
    }

    public List<String> getPermittedReagentCategories()
    {
        if (permittedContainerTypes == null)
        {
            permittedContainerTypes = new ArrayList<String>();
        }
        return permittedContainerTypes;
    }

    public String addPermittedReagentCategory(String category)
    {
        getPermittedReagentCategories().add(category);
        return category;
    }

    public String addPermittedReagentCategory(ReagentType reagentType)
    {
        String category = null;
        if (reagentType != null && reagentType.getReagentCategory() != null)
        {
            category = reagentType.getReagentCategory();
            getPermittedReagentCategories().add(category);
        }
        return category;
    }

    public List<ReagentKitLink> getRequiredReagentKits()
    {
        if (requiredReagentKits == null)
        {
            requiredReagentKits = new ArrayList<ReagentKitLink>();
        }
        return requiredReagentKits;
    }

    public ReagentKitLink addRequiredReagentKit(Linkable<ReagentKit> kit)
    {
        ReagentKitLink link = new ReagentKitLink(kit);
        getRequiredReagentKits().add(link);
        return link;
    }

    public List<ControlTypeLink> getPermittedControlTypes()
    {
        if (permittedControlTypes == null)
        {
            permittedControlTypes = new ArrayList<ControlTypeLink>();
        }
        return permittedControlTypes;
    }

    public ControlTypeLink addPermittedControlType(Linkable<ControlType> controlType)
    {
        ControlTypeLink link = new ControlTypeLink(controlType);
        getPermittedControlTypes().add(link);
        return link;
    }

    public List<NextStep> getTransitions()
    {
        if (transitions == null)
        {
            transitions = new ArrayList<NextStep>();
        }
        return transitions;
    }

    public NextStep addTransition(NextStep transition)
    {
        getTransitions().add(transition);
        return transition;
    }

    /**
     * Field by which the queue view samples will be grouped by default.
     *
     * @return Grouping field.
     */
    public String getDefaultGrouping()
    {
        return defaultGrouping;
    }

    public void setDefaultGrouping(String defaultGrouping)
    {
        this.defaultGrouping = defaultGrouping;
    }

    public List<QueueField> getQueueFields()
    {
        if (queueFields == null)
        {
            queueFields = new ArrayList<QueueField>();
        }
        return queueFields;
    }

    public QueueField addQueueField(QueueField field)
    {
        getQueueFields().add(field);
        return field;
    }

    public List<Field> getStepFields()
    {
        if (stepFields == null)
        {
            stepFields = new ArrayList<Field>();
        }
        return stepFields;
    }

    public Field addStepField(Field field)
    {
        getStepFields().add(field);
        return field;
    }

    public List<Field> getSampleFields()
    {
        if (sampleFields == null)
        {
            sampleFields = new ArrayList<Field>();
        }
        return sampleFields;
    }

    public Field setSampleFields(Field field)
    {
        getSampleFields().add(field);
        return field;
    }

    public List<StepProperty> getStepProperties()
    {
        if (stepProperties == null)
        {
            stepProperties = new ArrayList<StepProperty>();
        }
        return stepProperties;
    }

    public StepProperty addStepProperty(StepProperty property)
    {
        getStepProperties().add(property);
        return property;
    }

    public StepProperty addStepProperty(String name, String value)
    {
        return addStepProperty(new StepProperty(name, value));
    }

    public StepSetup getStepSetup()
    {
        return stepSetup;
    }

    public void setStepSetup(StepSetup stepSetup)
    {
        this.stepSetup = stepSetup;
    }

    public List<EppTrigger> getEppTriggers()
    {
        if (eppTriggers == null)
        {
            eppTriggers = new ArrayList<EppTrigger>();
        }
        return eppTriggers;
    }

    public EppTrigger addEppTriggers(EppTrigger trigger)
    {
        getEppTriggers().add(trigger);
        return trigger;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public URI getUri()
    {
        return uri;
    }

    public void setUri(URI uri)
    {
        this.uri = uri;
    }

    public URI getProtocolUri()
    {
        return protocolUri;
    }

    public void setProtocolUri(URI protocolUri)
    {
        this.protocolUri = protocolUri;
    }
}
