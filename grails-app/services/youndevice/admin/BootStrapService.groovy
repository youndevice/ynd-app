package youndevice.admin

import grails.transaction.Transactional

@Transactional
class BootStrapService {

    def createDummyAdminUser() {
        log.info(" ****** Inserting Dummy Admin User ****** ")
        User savedUser = User.findByUsername("admin@youndevice.com")
        if (!savedUser) {
            def adminRole = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
            User adminUser = new User(username: "admin@youndevice.com",
                    password: "admin")
            adminUser.save(failOnError: true)
            UserRole.create(adminUser, adminRole, true)
        }
    }

    def createUser() {
        log.info(" ****** Inserting Dummy User ****** ")
        User savedUser = User.findByUsername("user@test.com")
        if (!savedUser) {
            def adminRole = new Role(authority: 'ROLE_USER').save(failOnError: true)
            User adminUser = new User(username: "user@test.com",
                    password: "user")
            adminUser.save(failOnError: true)
            UserRole.create(adminUser, adminRole, true)
        }
    }
}
