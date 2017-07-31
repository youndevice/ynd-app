package com.youndevice.user

import com.youndevice.core.dto.EmailDTO
import com.youndevice.core.utils.CommonUtil
import grails.transaction.Transactional
import grails.web.mapping.LinkGenerator
import youndevice.admin.Role
import youndevice.admin.User
import youndevice.admin.UserRole

@Transactional
class UserService {

    def springSecurityService
    def sendMailService
    def grailsLinkGenerator

    def registerUser(def params){
        try{
            User user = new User(params)
            user.text = params.password
            user.token = CommonUtil.uniqueID
            user.enabled =false
            user.save(failOnError:true)
            Role role = Role.findByAuthority('ROLE_USER')
            UserRole.create(user,role,true)
            String confirmUrl = grailsLinkGenerator.link(controller: "user", action: "confirmUser", absolute: true,params:[authCode:user.token])
            String content ="Hi ${user.username}, <br/> Thanks for signing up on You N Device. Please click on below link to confirm your email.<br/> ${confirmUrl}"
            sendMailService.sendEmailDTO(new EmailDTO(toEmailId: user.username, body: content, subject: "User Registration"))
        }catch (Exception e){
            log.error("Error occurred while saving user",e)
        }
    }

    def getCurrentUser(){
        springSecurityService.currentUser
    }
}
