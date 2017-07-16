package youndevice.admin

import youndevice.admin.BootStrapService

class BootStrap {

    BootStrapService bootStrapService

    def init = { servletContext ->
        bootStrapService.createDummyAdminUser()
        bootStrapService.createUser()
    }
    def destroy = {
    }
}
