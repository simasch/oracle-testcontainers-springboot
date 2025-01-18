alter session set container=freepdb1;

grant create any synonym to demoowner;

create user demouser identified by "password";
grant connect, resource to demouser;