<!doctype html>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

</head>

<body>
<g:form controller="userDevice" action="saveDevice">
    Device Id
    <g:textField name="deviceId" value=""/>
    User Friendly Name
    <g:textField name="userFriendlyName" value=""/>
    <g:submitButton name="Submit"/>
</g:form>
</body>
</html>
