<!doctype html>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>List Appliance</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

</head>

<body>
Appliance List
<g:each in="${applianceList}" var="appliance" status="i">
    <div class="row">
        <div class="col-md-4">${appliance.applianceId}</div>
        <div class="col-md-4">${appliance.userFriendlyName}</div>
        <div class="col-md-2">${appliance.webStatus}</div>
        <div class="col-md-2">
            <g:link controller="userAppliance" action="toggleAppliance" id="${appliance.id}"> Switch ${appliance.webStatus.inverseValue}</g:link>
        </div>
    </div>
</g:each>
</body>
</html>
