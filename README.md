SHUOracleTest
=============

A sample grails app that connects to the uni oracle database instead of the local MySQL one

Steps to do this for your app:

1) Copy the oracle jdbc driver from /home/student/lib/ojdbc6.jar to your applications lib directory
2) Change the development datasource stanza in DataSource.groovy to

    dataSource {
            dialect = org.hibernate.dialect.Oracle10gDialect
            driverClassName = 'oracle.jdbc.driver.OracleDriver'
            username = 'a1112223344'
            password = '**'
            url = 'jdbc:oracle:thin:@homepages.shu.ac.uk:1521:SHU11G'
            dbCreate = 'update'
    }


EXCEPT - Replace a1112223344 with your student ID and password with the password you used for oracle. CRITICAL NOTE: Don't check your oracle password into GitHub - Thr whole world will be able to see it.

Running this app will create tables in Oracle instead of MySql.

Alternatively, you can override the existing datasource stanza by adding the file

~/.grails/oratest-config.groovy

This file lets you specify local only overrides to the app config, and is ideal, since it means you don't need to check in database username/password into git. The file should be of
the form

    dataSource.username="yourSHUStudentId"
    dataSource.password="yourOraclePassword"


N.B. A good approach might be to use MySQL in the development environment, but configure oracle for the production environment. By default

    grails run-app

Will use the development environment settings

    grails production run-app

Will run the app in the production environment

    grails war

Will package up the application for deployment using the production settings
