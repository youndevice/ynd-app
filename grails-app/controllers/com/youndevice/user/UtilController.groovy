package com.youndevice.user

import grails.transaction.Transactional
import youndevice.admin.User

@Transactional(readOnly = true)
class UtilController {

    def test(){
        log.info("******* Test Called *******")
    }
}
