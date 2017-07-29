<!doctype html>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

</head>

<body>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Device Id : ${device.deviceId}</h3>
    </div>
    <div class="panel-body">
        <g:if test="${device.applianceType.typeValue}">
            <g:each in="${1..device.applianceType.typeValue}" var="i">
                <g:set var="applianceInstance" value="${device?.appliances?.find { it.pinNumber == i }}"/>
                <div class="col-md-4">
                    <div class="jumbotron">
                        <g:if test="${applianceInstance}">
                            <h4>${applianceInstance?.applianceId}</h4>
                        </g:if>
                        <g:else>
                            <h4>Appliance ${i}</h4>
                            <g:link controller="userAppliance" action="addAppliance"
                                    params="[pinNumber: i, deviceId: device.id]" class="btn btn-danger">Add Appliance</g:link>
                        </g:else>
                    </div>
                </div>
            </g:each>
        </g:if>
    </div>
</div>
</body>
</html>
