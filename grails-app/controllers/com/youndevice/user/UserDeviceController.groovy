package com.youndevice.user

import grails.transaction.Transactional
import youndevice.admin.Device
import youndevice.admin.User

@Transactional(readOnly = true)
class UserDeviceController {

    def springSecurityService

    def listDevices(){
        User user = springSecurityService.currentUser
        [deviceList:user?.devices]
    }

    def addDevice() {
    }

    def saveDevice() {
        String deviceId = params.deviceId
        String userFriendlyName = params.userFriendlyName
        User user = springSecurityService.currentUser
        Boolean count = user.devices.count { it.deviceId == deviceId } as Boolean
        if (!count) {
            flash.success = 'device is successfully added to user'
            Device device = Device.findByDeviceId(deviceId)
            if (device) {
                device.userFriendlyName = userFriendlyName
                user.addToDevices(device)
                user.save(failOnError: true)
            }else{
                flash.error = "Invalid Device Id"
            }
        } else {
            flash.error = "This device is already added"
        }
        redirect(controller: 'userDevice', action: 'addDevice')
    }

    def showDevice(Long id){
        Device device = Device.read(id)
        [device:device]
    }
}
