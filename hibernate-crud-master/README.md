hibernate-crud
==============

  A Simple Hibernate Generic CRUD Framework
---------------------------------------------
	Requirements:
	- JBoss/Tomcat Server
	- Mysql 5.x DB
	- JDBC Mysql Driver
	- Maven
	- Eclipse IDE
	- JUnit 4.x
	----------------------
	  Setup Instructions:
	----------------------
	1.  Create the MySQL table "XXX" to test
	****************
	CREATE TABLE `XXX` (
	  `col1` int(11) NOT NULL AUTO_INCREMENT,
	  `col2` varchar(50) DEFAULT NULL,
	  `col3` varchar(50) DEFAULT NULL,
	  PRIMARY KEY (`user_id`)
	) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1

        col1, col2 and col3 are just example names provided. You can design your schema accordingly.
	*****************
	2. Import this as Maven project in your eclipse. 
	3. Update the project with your Maven and build again.
	
	---------------------------
	 How to Extend the Project
	---------------------------
	1. Configure hibernate.cfg.xml in the project according to your database.
	2. Review the User.hbm.xml so that you can create another mapping file for your own schemas/entities.
	3. Similar to the User module, you can add your own entity "Foo", create Foo.hbm.xml based on Foo entity.
	4. Create the FooDao interface that will extend the GenericDao
	5. Create the FooDaoImpl that will implement the GenericDao and extend from GenericDaoImpl.
	6. Ensure to add the mapping class and resource for your new entity to hiberntae.cfg.xml
	6. Create the FooTest Junit class to test the implementations of your CRUD Methods
	7. You are done! Enjoy extending the code 
	
	---------------------
	  You should Already Know?
	---------------------
	1. You should be familiar with all OOP concepts.
	2. You should be familiar with the Factory pattern
	3. Basic Hibernate Configuration and Mappings
	4. Basic idea of why JUnit should be used.
	
	----------------------------------
	  Ways to Enhance further?
	----------------------------------
	1. JUnit Tests require assertions for all test steps.
	2. Integration tests suite can be created for available Unit tests.
	3. You can develop a service contract, Views and Controllers on top of this boiler plate package.
	4. You can refactor further to use it with any REST/SOAP API that needs a persistence model.
	5. You can remove the hibernate layer and replace with JPA for persistence.
	
