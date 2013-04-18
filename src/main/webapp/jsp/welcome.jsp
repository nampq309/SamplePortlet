<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<div class="portlet-section-header">Welcome !</div>

<br/>

<div class="portlet-font">Welcome on the JSP Hello User portlet,
my name is JBoss Portal. What's yours ?</div>


<portlet:renderURL var="myRenderURL">
    <portlet:param name="yourname" value='John Doe'/>
</portlet:renderURL>
<br/>
<div class="portlet-section-header"><%= myRenderURL %></div>
<br/>

<portlet:actionURL var="myActionURL"/>

<div class="portlet-section-header">Action URL: <%= myActionURL %></div>
<form action="<%= myActionURL %>" method="POST">
         <span class="portlet-form-field-label">Name:</span>
         <input class="portlet-form-input-field" type="text" name="yourname"/>
         <input class="portlet-form-button" type="Submit"/>
</form>
