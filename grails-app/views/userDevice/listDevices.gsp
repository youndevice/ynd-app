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
    <div class="well">
        <div class="media">
            <a class="pull-left" href="#">
                <img class="media-object" src="http://placekitten.com/150/150">
            </a>
            <div class="media-body">
                <h4 class="media-heading">
                    <g:link controller="userDevice" action="showDevice" id="${device.id}">
                        ${device.deviceId}
                    </g:link>
                </h4>
                <p>${device.userFriendlyName}</p>
                <p>Up Time : 2h 30m</p>
            </div>
        </div>
    </div>
</g:each>
</body>
</html>
