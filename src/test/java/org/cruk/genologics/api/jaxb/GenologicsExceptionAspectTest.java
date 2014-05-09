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

package org.cruk.genologics.api.jaxb;

import static org.junit.Assert.*;

import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.cruk.genologics.api.GenologicsException;
import org.cruk.genologics.api.unittests.UnitTestApplicationContextFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class GenologicsExceptionAspectTest
{
    protected Jaxb2Marshaller marshaller;

    public GenologicsExceptionAspectTest()
    {
        ApplicationContext context = UnitTestApplicationContextFactory.getApplicationContext();
        marshaller = context.getBean("genologicsJaxbMarshaller", Jaxb2Marshaller.class);
    }

    @Test
    public void testExceptionAspect()
    {
        Source source = new StreamSource(new File("src/test/xml/exceptionaspecttest-exception.xml"));

        try
        {
            marshaller.unmarshal(source);
            fail("Didn't get a GenologicsException when unmarshalling an exception.");
        }
        catch (GenologicsException e)
        {
            assertEquals("Exception message wrong",
                         "Could not find resource for relative : /v2/process-executions of full path: http://limsdev.cri.camres.org:8080/api/v2/process-executions",
                         e.getMessage());
            assertEquals("Exception category wrong", "Highest", e.getCategory());
            assertEquals("Exception suggested actions wrong", "Check URL", e.getSuggestedActions());
            assertEquals("Exception code wrong", "ACODE", e.getCode());
        }
    }
}
