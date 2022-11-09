# -*- mode: ruby -*-
# vi: set ft=ruby :


Vagrant.configure("2") do |config|


config.vm.provider "virtualbox" do |h, override|
  h.gui = false
  h.memory = 1024
  h.cpus = 2

  override.vm.network "private_network", type: "dhcp"
  
end

 




config.vm.define "mariadb", primary: true do |mariadb|
  mariadb.vm.box = "centos/stream8"
  mariadb.vm.hostname = "mariadb"
  mariadb.vm.network "private_network", ip: "192.168.56.102"
 

  mariadb.vm.provision "shell", inline: <<-SHELL
   sudo dnf install -y python3-pip
   sudo dnf install -y mariadb-server
  SHELL

  mariadb.vm.provision "shell", inline: <<-SHELL
  
  sed -i '$a bind-address=0.0.0.0' /etc/my.cnf.d/mariadb-server.cnf

  sudo systemctl start mariadb
  

  sudo /usr/bin/mysqladmin -u root password 'password'
  mysql -u root -ppassword -e "GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'password' WITH GRANT OPTION; FLUSH PRIVILEGES;"

 

  sudo systemctl restart mariadb

  mysql -u root -ppassword -e "create database test;"
  mysql -u root -ppassword -e "CREATE TABLE test.information (id int not null auto_increment, firstName varchar(40) not null, lastName varchar(40) not null, age int not null, address varchar(128) not null, PRIMARY KEY (id));"
  mysql -u root -ppassword -e "CREATE USER 'niuniu'@'192.168.56.102' IDENTIFIED BY 'password';"
  mysql -u root -ppassword -e "GRANT USAGE ON *.* TO 'niuniu'@'%' IDENTIFIED BY 'password'; FLUSH PRIVILEGES;"
  mysql -u root -ppassword -e "GRANT ALL PRIVILEGES ON *.* TO 'niuniu'@'%'; FLUSH PRIVILEGES;"


  
  SHELL

  mariadb.vm.provision "shell", inline: <<-SHELL

  sudo systemctl start firewalld

  sudo firewall-cmd --add-port=3306/tcp --permanent
  sudo firewall-cmd --add-source=192.168.1.102/24 --permanent
  sudo firewall-cmd --reload

  SHELL



end


end
