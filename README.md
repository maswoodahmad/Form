. hsqldb.org
	download the db 2.6.1
2. extract the zip

3. goto the lib folder of the extracted folder

4. and start the cmd in it.

TO START THE HSQLDB SERVER -> 
	java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 xdb



5. and star the another cmd in it.

	TO START THE HSQLDB INTERFACE -> java -jar hsqldb.jar

6. once the interface appread, select the TYPE : engine server
	URL : jdbc:hsqldb:hsql://localhost/xdb
	
	xdb as the database name at the end of the URL
