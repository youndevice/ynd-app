<!doctype html>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>Add Appliance</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

</head>

<body>
<g:form controller="userAppliance" action="saveAppliance">
    <g:hiddenField name="pinNumber" value="${appliance.pinNumber}"/>
    <g:hiddenField name="deviceId" value="${deviceId}"/>
    <g:hiddenField name="applianceInstanceId" value="${appliance.id}"/>
    Appliance Category
    <g:select from="${com.youndevice.core.enums.ApplianceCategory.values()}" name="category" value="${appliance.category}"/>
    User Friendly Name
    <g:textField name="userFriendlyName" value="${appliance.userFriendlyName}"/>
    <g:submitButton name="Submit"/>
</g:form>
</body>
</html>
