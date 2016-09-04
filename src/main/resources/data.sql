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

insert into blah.app_group (name, city_id, interest_id) values ('TestGroup', 2, 1);

insert into blah.group_people (groups_id, members_id) values (1, 1);

insert into blah.interest_people (interests_id, people_id) values (1, 1);
insert into blah.interest_people (interests_id, people_id) values (2, 1);
insert into blah.interest_people (interests_id, people_id) values (3, 1);
