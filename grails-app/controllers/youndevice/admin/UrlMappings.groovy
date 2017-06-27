package youndevice.admin

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/login"(view:"/signin")
        "/register"(view:"/signup")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
