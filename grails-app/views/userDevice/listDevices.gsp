<!doctype html>
<html>
<head>
    <meta name="layout" content="user"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

</head>

<body>
Device List
<g:each in="${deviceList}" var="device" status="i">
    <div class="row">
        <div class="col-md-4">${device.deviceId}</div>
        <div class="col-md-4">${device.userFriendlyName}</div>
    </div>
</g:each>
</body>
</html>
