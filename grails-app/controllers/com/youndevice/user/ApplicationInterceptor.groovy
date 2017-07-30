package com.youndevice.user

import youndevice.admin.User


class ApplicationInterceptor {

    def springSecurityService

    ApplicationInterceptor(){
        matchAll()
    }

    boolean before() {
        log.info("***** Logging Request *****")
        log.info("params : ${params}")
//        log.info("IP Address : ${request.getRemoteAddr()}")
//        log.info("User Agent : ${request.getUser}")
        true
    }

    boolean after() {
        User user = springSecurityService.currentUser
        def deviceList =user?.devices
        List applianceList = deviceList.collect {
            it.appliances
        }
        applianceList = applianceList.flatten()
//        model.deviceList = deviceList
        model?.applianceList = applianceList
        true
    }

    void afterView() {
        // no-op
    }
}
