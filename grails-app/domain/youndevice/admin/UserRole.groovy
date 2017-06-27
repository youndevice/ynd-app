package youndevice.admin

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.codehaus.groovy.util.HashCodeHelper
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class UserRole implements Serializable {

	private static final long serialVersionUID = 1

	User adminUser
	Role adminRole

	@Override
	boolean equals(other) {
		if (other instanceof UserRole) {
			other.adminUserId == adminUser?.id && other.adminRoleId == adminRole?.id
		}
	}

    @Override
	int hashCode() {
	    int hashCode = HashCodeHelper.initHash()
        if (adminUser) {
            hashCode = HashCodeHelper.updateHash(hashCode, adminUser.id)
		}
		if (adminRole) {
		    hashCode = HashCodeHelper.updateHash(hashCode, adminRole.id)
		}
		hashCode
	}

	static UserRole get(long adminUserId, long adminRoleId) {
		criteriaFor(adminUserId, adminRoleId).get()
	}

	static boolean exists(long adminUserId, long adminRoleId) {
		criteriaFor(adminUserId, adminRoleId).count()
	}

	private static DetachedCriteria criteriaFor(long adminUserId, long adminRoleId) {
		UserRole.where {
			adminUser == User.load(adminUserId) &&
			adminRole == Role.load(adminRoleId)
		}
	}

	static UserRole create(User adminUser, Role adminRole, boolean flush = false) {
		def instance = new UserRole(adminUser: adminUser, adminRole: adminRole)
		instance.save(flush: flush)
		instance
	}

	static boolean remove(User u, Role r) {
		if (u != null && r != null) {
			UserRole.where { adminUser == u && adminRole == r }.deleteAll()
		}
	}

	static int removeAll(User u) {
		u == null ? 0 : UserRole.where { adminUser == u }.deleteAll() as int
	}

	static int removeAll(Role r) {
		r == null ? 0 : UserRole.where { adminRole == r }.deleteAll() as int
	}

	static constraints = {
		adminRole validator: { Role r, UserRole ur ->
			if (ur.adminUser?.id) {
				UserRole.withNewSession {
					if (UserRole.exists(ur.adminUser.id, r.id)) {
						return ['userRole.exists']
					}
				}
			}
		}
	}

	static mapping = {
		id composite: ['adminUser', 'adminRole']
		version false
	}
}
