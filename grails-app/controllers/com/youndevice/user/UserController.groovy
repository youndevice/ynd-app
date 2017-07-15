package com.youndevice.user

import grails.transaction.Transactional
import youndevice.admin.Device
import youndevice.admin.User

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class UserController {

    def userService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def registerUser() {
        userService.registerUser(params)
        redirect(uri: '/')
    }

    def home(){
        User user = springSecurityService.currentUser
        def deviceList =user?.devices
        List applianceList = deviceList.collect {
            it.appliances
        }
        applianceList = applianceList.flatten()
        [deviceList:deviceList,applianceList:applianceList]
    }

}
