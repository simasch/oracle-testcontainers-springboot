insert into address(id, version, street, postal_code, city) values (1, 1, 'Bahnhofstrasse 11', '2501', 'Biel/Bienne');
insert into address(id, version, street, postal_code, city) values (2, 1, 'Gässli 11', '3210', 'Kerzers');

insert into firm(id, version, name, address_id) values (1, 1, 'Restaurant Bahnhof', 1);
insert into firm(id, version, name, address_id) values (2, 1, 'Käserei Kerzers', 2);

insert into customer(id, version, first_name, last_name, firm_id, created_date, picture) values (1, 1, 'Hans', 'Muster', 1,  TO_UTC_TIMESTAMP_TZ('2017-05-25T11:03:22'), 'https://gravatar.com/avatar/f9e72e72f6d44802f19843eca1ac16c4?s=400&d=robohash&r=x');
insert into customer(id, version, first_name, last_name, firm_id, created_date, picture) values (2, 1, 'Petra', 'Muster', 1, TO_UTC_TIMESTAMP_TZ('2011-03-21T11:03:22'),'https://gravatar.com/avatar/a3fa221bd868daffb68e9f987003421e?s=400&d=robohash&r=x');
insert into customer(id, version, first_name, last_name, firm_id, created_date, picture) values (3, 1, 'Carla', 'Tschachtli', 2, TO_UTC_TIMESTAMP_TZ('2023-12-20T11:03:22'), 'https://gravatar.com/avatar/94d29290712a487d530d6defe22eee87?s=400&d=robohash&r=x');
