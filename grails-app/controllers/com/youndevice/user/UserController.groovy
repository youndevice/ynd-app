package com.youndevice.user

import grails.transaction.Transactional
import youndevice.admin.Device

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class UserController {

    def userService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def registerUser() {
        userService.registerUser(params)
        redirect(uri: '/')
    }

}
