/*
 * Copyright (C) 2003-2013 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU Affero General Public License
* as published by the Free Software Foundation; either version 3
* of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SamplePortlet extends GenericPortlet {
  
  //Constants of VIEW paths
  private final String HELLO_VIEW = "/jsp/hello.jsp";
  private final String WELCOME_VIEW = "/jsp/welcome.jsp";
  private final String EDIT_VIEW = "/jsp/edit.jsp";
  private final String HELP_VIEW = "/jsp/help.jsp";
  
  public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
    String sYourName = (String) request.getParameter("yourname");
    if (sYourName != null) {
        renderResponse(request, response, HELLO_VIEW);
    } else {
        renderResponse(request, response, WELCOME_VIEW);
    }
  }
  
  protected void doHelp(RenderRequest rRequest, RenderResponse rResponse) throws PortletException, IOException {
    renderResponse(rRequest, rResponse, HELP_VIEW);
  }
  
  protected void doEdit(RenderRequest rRequest, RenderResponse rResponse) throws PortletException, IOException {
    renderResponse(rRequest, rResponse, EDIT_VIEW);
  }

  public void processAction(ActionRequest aRequest, ActionResponse aResponse) throws PortletException, IOException {
    String sYourname = (String) aRequest.getParameter("yourname");
    aResponse.setRenderParameter("yourname", sYourname);
  }
  
  private void renderResponse(RenderRequest rRequest, RenderResponse rResponse, String path) throws PortletException, IOException {
    rResponse.setContentType("text/html");
    PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher(path);
    prd.include(rRequest, rResponse);
  }
  
}
