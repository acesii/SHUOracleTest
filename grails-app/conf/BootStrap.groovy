class BootStrap {

  def grailsApplication

    def init = { servletContext ->
       log.debug("Ora Username : ${grailsApplication.config.dataSource.username}")
    }
    def destroy = {
    }
}
