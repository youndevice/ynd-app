package youndevice.admin

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'user',action: 'home')
//        "/"(view:"/comingsoon")
        "/personalized-birthday-card"(controller: 'util',action: 'test')
        "/login"(view:"/signin")
        "/comingsoon"(view:"/comingsoon")
        "/home"(controller: 'user',action: 'home')
        "/register"(view:"/signup")
        "/error"(view:"/error")
        "500"(view:'/error')
        "404"(view:'/notFound')

        "/device/addDevice"(controller: 'userDevice',action: 'addDevice')

//        "/admin"(controller: 'login',action: 'auth')
        "/device/$action"(controller: 'adminDevice')
        "/device/$action/$id"(controller: 'adminDevice')
        "/appliance/$action"(controller: 'adminAppliance')
        "/appliance/$action/$id"(controller: 'adminAppliance')
        "/admin/appliance/$action"(controller: 'adminAppliance')
    }
}
