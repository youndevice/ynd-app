package com.youndevice.user


class ApplicationInterceptor {

    ApplicationInterceptor(){
        matchAll()
    }

    boolean before() {
        log.info("***** Logging Request *****")
        log.info("params : ${params}")
        log.info("IP Address : ${request.getRemoteAddr()}")
//        log.info("User Agent : ${request.getUser}")
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
