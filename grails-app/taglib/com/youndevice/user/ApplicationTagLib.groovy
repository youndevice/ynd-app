package com.youndevice.user

import youndevice.admin.User

class ApplicationTagLib {

    def userService

    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    static namespace = 'ynd'

    def loggedInUser = {
        User user = userService.getCurrentUser()
        String userName = user?.username
        out << "${userName}"
    }
}
