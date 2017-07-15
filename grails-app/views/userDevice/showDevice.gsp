<!doctype html>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

</head>

<body>
Device Id : ${device.deviceId}
<g:if test="${device.applianceType.typeValue}">
    <g:each in="${1..device.applianceType.typeValue}" var="i">
        <g:set var="applianceInstance" value="${device?.appliances?.find { it.pinNumber == i }}"/>
        <div class="col-md-3">
            <div class="jumbotron">
                    <g:if test="${applianceInstance}">
                        <h4>${applianceInstance?.applianceId}</h4>
                    </g:if>
                    <g:else>
                        <h4>Appliance ${i}</h4>
                        <g:link controller="userAppliance" action="addAppliance"
                                params="[pinNumber: i, deviceId: device.id]">Add Appliance</g:link>
                    </g:else>
            </div>
        </div>
    </g:each>
</g:if>
</body>
</html>
