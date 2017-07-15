package com.youndevice.user

import grails.transaction.Transactional
import youndevice.admin.Role
import youndevice.admin.User
import youndevice.admin.UserRole

@Transactional
class UserService {

    def registerUser(def params){
        User user = new User(params)
        user.text = params.password
        user.save(failOnError:true)
        Role role = Role.findByAuthority('ROLE_USER')
        UserRole.create(user,role,true)
    }
}
