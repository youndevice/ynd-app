package youndevice.admin

import grails.plugin.springsecurity.SpringSecurityService
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	SpringSecurityService springSecurityService

	String firstName
	String lastName
	String mobileNumber
	String text
	String username
	String password
	String token
	boolean enabled = true
	boolean accountExpired = false
	boolean accountLocked =false
	boolean passwordExpired = false

	static hasMany = [devices:Device]

	Set<Role> getAuthorities() {
		(UserRole.findAllByAdminUser(this) as List<UserRole>)*.adminRole as Set<Role>
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		password blank: false, password: true
		username blank: false, unique: true
		firstName nullable: true,blank: true
		lastName nullable: true,blank: true
		mobileNumber nullable: true,blank: true
		text nullable: true,blank: true
		token nullable: true,blank: true
	}

	static mapping = {
		password column: '`password`'
	}
}
