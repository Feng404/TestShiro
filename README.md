# 数据库SYS_USER表结构
```sql
create table SYS_USER
(
  id                 VARCHAR2(64) default sys_guid() not null,
  user_name          VARCHAR2(64),
  user_password      VARCHAR2(64) default 123,
  user_login_name    VARCHAR2(64),
  permissions        VARCHAR2(100),
  roles              VARCHAR2(100)
)

```

# 数据库SYS_USER测试数据  
```sql
insert into sys_user (ID, USER_NAME, USER_PASSWORD, USER_LOGIN_NAME, PERMISSIONS, ROLES)
values ('B85DD9586BBFE56EE0538B08000A664B', '赵一剑', '123', 'zhaoyijian', 'manage', 'administrator');

insert into sys_user (ID, USER_NAME, USER_PASSWORD, USER_LOGIN_NAME, PERMISSIONS, ROLES)
values ('B85DD9586C01E56EE0538B08000A664B', '苏般若', '123', 'subanruo', 'manage', null);

insert into sys_user (ID, USER_NAME, USER_PASSWORD, USER_LOGIN_NAME, PERMISSIONS, ROLES)
values ('B85DD9586C02E56EE0538B08000A664B', '田野', '123', 'tianye', null, null);
```