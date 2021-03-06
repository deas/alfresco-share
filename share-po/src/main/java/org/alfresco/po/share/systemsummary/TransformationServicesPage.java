/*
 * #%L
 * share-po
 * %%
 * Copyright (C) 2005 - 2016 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

package org.alfresco.po.share.systemsummary;

import static com.google.common.base.Preconditions.checkNotNull;

import org.alfresco.po.HtmlPage;
import org.alfresco.po.RenderTime;
import org.alfresco.po.RenderWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * Created by olga.lokhach
 */
public class TransformationServicesPage extends AdvancedAdminConsolePage
{
    @RenderWebElement
    private final static By SAVE_BUTTON = By.xpath("//input[@value='Save']");
    @RenderWebElement
    private final static By CANCEL_BUTTON = By.xpath("//input[@value='Cancel']");

    //Office Transform - JODConverter
    @RenderWebElement
    private final static By JODCONVERTER_ENABLED_CHECKBOX = By.cssSelector("input[onchange*='jodconverter.enabled']");
    @RenderWebElement
    private final static By JODCONVERTER_PORT_INPUT = By.cssSelector("input[name$='jodconverter.portNumbers']");
    @SuppressWarnings("unchecked")
    @Override
    public synchronized TransformationServicesPage render(RenderTime timer)
    {
        webElementRender(timer);
        return this;
    }


    @SuppressWarnings("unchecked")
    @Override
    public TransformationServicesPage render()
    {
        return render(new RenderTime(maxPageLoadingTime));
    }

    private void click(By locator)
    {
        checkNotNull(locator);
        WebElement element = findAndWait(locator);
        element.click();
    }
    /**
     * Method to enable or disable the FTP server
     */

    public HtmlPage selectJODConverterEnabledCheckbox()
    {
        findAndWait(JODCONVERTER_ENABLED_CHECKBOX).click();
        click(SAVE_BUTTON);
        return getCurrentPage();
    }

    /**
     * Is check box selected
     *
     * @return - Boolean
     */
    public boolean isJODConverterEnabledSelected()
    {
        try
        {
            return (driver.findElement(JODCONVERTER_ENABLED_CHECKBOX).isSelected());
        }
        catch (NoSuchElementException nse)
        {
            return false;
        }
    }
}
