use `final`;

create table comments
 (id bigint not null auto_increment,
  context varchar(255),
   created_date date,
    user_id bigint,
     primary key (id));

create table photo
(id bigint not null auto_increment,
 photo_name_path varchar(255),
  primary key (id));

create table places
(id bigint not null auto_increment,
 counter double precision,
  description_of_place varchar(255),
   main_photo_path varchar(255),
    name_of_place varchar(255),
     primary key (id));

create table places_comment
(place_id bigint not null,
 comment_id bigint not null);

create table places_photos
 (place_id bigint not null,
  photos_id bigint not null);

create table users
 (id bigint not null auto_increment,
 email varchar(255), name varchar(255),
 password varchar(255), surname varchar(255),
  primary key (id));

alter table places_comment add constraint UK_d4j1g8o0jeneank6tgrfxb1p unique (comment_id);
alter table places_photos add constraint UK_jqbo5vpxoe2xck240ecmd1eoj unique (photos_id);
alter table comments add constraint FK8omq0tc18jd43bu5tjh6jvraq foreign key (user_id) references users (id);
alter table places_comment add constraint FK1xfppf3idfnlv09vekxsdp3ud foreign key (comment_id) references comments (id);
alter table places_comment add constraint FKdw6fdekbr60wej80i89143kuj foreign key (place_id) references places (id);
alter table places_photos add constraint FK6vl8ux12try82hqn9d7av5ob3 foreign key (photos_id) references photo (id);
alter table places_photos add constraint FK82keyto334lilggte8ad3ldlj foreign key (place_id) references places (id);