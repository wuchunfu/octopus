# MetaDef

## hive

* hive_db
```
database 
db_name 
comment 
location 
owner_name 
owner_type 
paramters 
tables

```
* hive_table

```
table 
partitioned by 
row format serde 
stored as inputformat 
outputformat 
location 
tblproperties 
columns 
partitions

```

* hive_column

```
column 
col_name 
data_type 
comment
```

```sql

decribe database db01
show create table tbl01
decribe db01.tbl01 col01

```

## pulsar 

* pulsar_cluster

```
name
description
service-url
token
```

* pulsar_topic

```
name
description
cluster
```
