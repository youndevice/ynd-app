package com.youndevice.user

import com.youndevice.core.utils.CommonUtil
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
        String emailId = params.username
        Boolean isEmailValid = CommonUtil.isValidEmail(emailId)
        Boolean count = User.countByUsername(emailId) as Boolean
        if (isEmailValid) {
            if (count) {
                flash.error = 'You are already registered with us. kindly login to continue.'
            } else {
                userService.registerUser(params)
                render(view: '/verifyUser')
            }
        } else {
            flash.error = "Invalid Email"
            render(view: '/signup')
        }
    }

    def home() {
        User user = springSecurityService.currentUser
        def deviceList = user?.devices
        List applianceList = deviceList.collect {
            it.appliances
        }
        applianceList = applianceList.flatten()
        [deviceList: deviceList, applianceList: applianceList]
    }

    def confirmUser(String authCode) {
        String message = "success"
        Boolean isAuthenticated = false
        if (authCode) {
            User user = User.findByToken(authCode)
            if (user) {
                user.enabled = true
                user.save(failOnError: true)
                isAuthenticated = true
            } else {
                message = "Invalid Auth Code."
            }
        } else {
            message = "Auth code is required."
        }
        [isAuthenticated: isAuthenticated, message: message]
    }

}
