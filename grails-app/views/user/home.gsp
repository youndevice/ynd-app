<!doctype html>
<html>
<head>
    <meta name="layout" content="home"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

</head>

<body>
<g:link controller="userDevice" action="addDevice">Add Device</g:link>
<br/>
<g:link controller='logout'>Logout</g:link>
<br/>

<div>Device List</div>
<g:each in="${deviceList}" var="device">
<div class="row">
    <div class="col-md-12">
        <g:link controller="userDevice" action="showDevice" id="${device.id}">${device.deviceId}</g:link>
    </div>
</div>
</g:each>
</body>
</html>
