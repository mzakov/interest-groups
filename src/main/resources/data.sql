insert into blah.app_state (name) values ('Florida');

insert into blah.app_city (name, state_id) values ('Tampa', 1);
insert into blah.app_city (name, state_id) values ('Palm Harbor', 1);
insert into blah.app_city (name, state_id) values ('St. Pete', 1);
insert into blah.app_city (name, state_id) values ('Largo', 1);

insert into blah.app_interest (name) values ('Music');
insert into blah.app_interest (name) values ('Games');
insert into blah.app_interest (name) values ('Movies');
insert into blah.app_interest (name) values ('Sport');
insert into blah.app_interest (name) values ('Animals');
insert into blah.app_interest (name) values ('Food');

insert into blah.app_person (name, city_id) values ('Marara', 2);
insert into blah.app_person (name, city_id) values ('Martin', 2);
insert into blah.app_person (name, city_id) values ('Trololo', 3);
insert into blah.app_person (name, city_id) values ('John', 2);

insert into blah.app_group (name, city_id, interest_id) values ('Music-PH', 2, 1);
insert into blah.app_group (name, city_id, interest_id) values ('Games-PH', 2, 2);
insert into blah.app_group (name, city_id, interest_id) values ('Movies-SP', 3, 3);

insert into blah.group_people (groups_id, members_id) values (1, 1);
insert into blah.group_people (groups_id, members_id) values (1, 2);
insert into blah.group_people (groups_id, members_id) values (2, 3);
insert into blah.group_people (groups_id, members_id) values (2, 2);
insert into blah.group_people (groups_id, members_id) values (1, 3);
insert into blah.group_people (groups_id, members_id) values (3, 3);
insert into blah.group_people (groups_id, members_id) values (3, 1);

insert into blah.interest_people (interests_id, people_id) values (1, 1);
insert into blah.interest_people (interests_id, people_id) values (1, 2);
insert into blah.interest_people (interests_id, people_id) values (3, 3);
insert into blah.interest_people (interests_id, people_id) values (2, 4);
