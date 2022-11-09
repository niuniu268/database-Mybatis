# database-Mybatis

This project is primarily to use mybatis. We use Vagrantfile to create a VM in which mariadb is created. To install **VirtualBox** and **Vagrant** are prerequisites. 

``` vagrant up ```

The database address is

``` 192.168.56.102 ```

the user name of the database is "niuniu" and password is "password", so please run:

```mysql -u niuniu -p -h 192.168.56.102```

The database "test" and the table "information" have created by vagrantfile. So, feel free to insert data into the table.

The java program is to connect 192.168.56.102/test. If you want to use other table, please change mybatis-config.xml
