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

package org.cruk.genologics.api.debugging;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

/**
 * Testing aspect that reports on the calls being made by the HTTP client
 * talking to the Genologics API. Reports on the URI being called and the
 * time the call took to execute.
 */
@Aspect
public class HttpClientTimingAspect
{
    /**
     * Logger for the messages.
     */
    private Log logger = LogFactory.getLog(HttpClientTimingAspect.class);

    /**
     * Join point that, if the logging is set to DEBUG, will report on the
     * call made with the HttpClient and the time taken to get a response.
     *
     * @param pjp The AspectJ join point object. One of the arguments in
     * this object must be the HttpMethod being invoked.
     *
     * @return The result of proceeding with the join point.
     *
     * @throws Throwable if there is any failure.
     *
     * @see HttpClient#executeMethod(HttpMethod)
     */
    public Object timeCall(ProceedingJoinPoint pjp) throws Throwable
    {
        if (!logger.isDebugEnabled())
        {
            return pjp.proceed();
        }

        String uri = "<no url>";
        String method = "<unknown>";

        for (Object arg : pjp.getArgs())
        {
            if (arg instanceof HttpMethod)
            {
                HttpMethod httpMethod = (HttpMethod)arg;
                uri = httpMethod.getURI().getEscapedURI();
                method = httpMethod.getName();
                break;
            }
        }

        long startTime = System.currentTimeMillis();

        try
        {
            return pjp.proceed();
        }
        finally
        {
            long endTime = System.currentTimeMillis();

            double timeTaken = (endTime - startTime) / 1000.0;

            logger.debug("HTTP " + method + " call to " + uri + " took " + timeTaken + " seconds.");
        }
    }
}
