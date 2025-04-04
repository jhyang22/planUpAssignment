create table plan
(
    id bigint auto_increment primary key '식별자',
    user_id bigint not null '작성자 식별자',
    title varchar(255) not null '제목',
    contents varchar(255) not null '할일',
    created_at datetime(6) not null '작성일',
    updated_at datetime(6) null '수정일',
    constraint plan_fk foreign key (user_id) references user (id)
);


create table user
(
    id bigint auto_increment primary key '식별자',
    user_name varchar(255) not null '작성자',
    password varchar(255) not null '비밀번호',
    email varchar(255) not null '이메일',
    created_at datetime(6) not null '작성일',
    updated_at datetime(6) null '수정일'
);