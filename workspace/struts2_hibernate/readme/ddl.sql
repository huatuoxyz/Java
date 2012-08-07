
CREATE TABLE `department` (
  `departmentid` int(10) NOT NULL auto_increment,
  `name` varchar(256) default NULL,
  PRIMARY KEY  (`departmentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `department` (`departmentid`,`name`) VALUES 
 (1,'Accounting'),
 (2,'HR'),
 (3,'Sales'),
 (4,'R & D');

CREATE TABLE `employee` (
  `employeeid` int(10) NOT NULL auto_increment,
  `firstname` varchar(256) default NULL,
  `lastname` varchar(256) default NULL,
  `age` int(10) default NULL,
  `departmentid` int(10) default NULL,
  PRIMARY KEY  (`employeeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `employee` (`employeeid`,`firstname`,`lastname`,`age`,`departmentid`) VALUES 
 (1,'Bob','Smith',25,3),
 (2,'John','Doe',36,1),
 (3,'Andy','Ma',30,4),
 (4,'Rick','Reumann',28,2),
 (5,'Tony','Lee',45,4);

