// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'youndevice.admin.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'youndevice.admin.UserRole'
grails.plugin.springsecurity.authority.className = 'youndevice.admin.Role'
grails.plugin.springsecurity.auth.loginFormUrl = '/login'
grails.plugin.springsecurity.logout.postOnly = false
//grails.plugin.springsecurity.auth.loginFormUrl = '/login/auth'
//grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/admin/dashboard'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/home'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['ROLE_USER']],
        [pattern: '/userDevice/**', access: ['ROLE_USER']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['ROLE_USER']],
        [pattern: '/admin/**', access: ['permitAll']],
        [pattern: '/adminDevice/**', access: ['permitAll']],
        [pattern: '/adminAppliance/**', access: ['permitAll']],
        [pattern: '/signin', access: ['permitAll']],
        [pattern: '/signup', access: ['permitAll']],
        [pattern: '/signup', access: ['permitAll']],
        [pattern: '/user/**', access: ['permitAll']],
//        [pattern: '/index.gsp', access: ['ROLE_ADMIN']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/**/console/**', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**/console*/**', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS']
]

