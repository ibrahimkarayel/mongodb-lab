
#MongoDB lab Java Project

Mongo lab lab Remote connection With Java Driver

Java 1.8
MongoDb <version>3.2.0</version>
and  JUnit  <version>4.12</version>  is used

This project satisfy basic mongo db crud operation.

sing in MongoDb Lab: https://mongolab.com/login/

Create new mongo DB deployment database and add collection

Copy and paste below url to  config.properties file under the resources folder
also update <dbuser>:<dbpassword>

To connect using a driver via the standard MongoDB URI (what's this?):
  mongodb://<dbuser>:<dbpassword>@ds035965.mongolab.com:35965/mydb


All method implement under MongoDocumentDaoImpl class.

UserDocumentDaoImpl is another specific dao for User Collection

Two collection( Route and User) are used for demonstrations.


ref https://mongolab.com/

