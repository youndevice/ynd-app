package youndevice.admin

import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class AdminController {

    static defaultAction = "dashboard"

    def dashboard(){
    }
}
