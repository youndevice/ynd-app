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
        println ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>home called"
        [deviceList:user?.devices]
    }

}
