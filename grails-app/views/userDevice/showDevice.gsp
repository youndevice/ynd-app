<!doctype html>
<html>
<head>
    <meta name="layout" content="home"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

</head>

<body>
Device Id : ${device.deviceId}
<g:if test="${device.applianceType.typeValue}">
    <g:each in="${1..device.applianceType.typeValue}" var="i">
        <div class="col-md-3">
            <div class="jumbotron">
                <h4>Appliance ${i}</h4>
                <g:link controller="userAppliance" action="addAppliance">Add Appliance</g:link>
            </div>
        </div>
    </g:each>
</g:if>
</body>
</html>
