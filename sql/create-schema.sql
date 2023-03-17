
    create table cart_details (
       id bigint not null auto_increment,
        date_created date not null,
        qty integer not null,
        cart_id bigint,
        product_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table carts (
       id bigint not null auto_increment,
        date_created date not null,
        date_deleted date,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table categories (
       id bigint not null auto_increment,
        date_created datetime(6) not null,
        date_deleted datetime(6),
        name varchar(255) not null,
        parent_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table order_details (
       id bigint not null auto_increment,
        date_created date not null,
        qty integer not null,
        order_id bigint,
        product_order_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table orders (
       id bigint not null auto_increment,
        date_created date not null,
        date_deleted date,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table products (
       id bigint not null auto_increment,
        date_created datetime(6) not null,
        date_deleted datetime(6),
        description varchar(255) not null,
        name varchar(255) not null,
        price decimal(19,2) not null,
        qty integer not null,
        category_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table products_order (
       id bigint not null auto_increment,
        date_created date not null,
        date_deleted date,
        description varchar(255) not null,
        name varchar(255) not null,
        price decimal(19,2) not null,
        category_id bigint not null,
        primary key (id)
    ) engine=InnoDB;

    create table users (
       id bigint not null auto_increment,
        date_created datetime(6) not null,
        date_deleted datetime(6),
        email varchar(255) not null,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        password varchar(255) not null,
        role varchar(255),
        username varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    alter table categories 
       add constraint UK_t8o6pivur7nn124jehx7cygw5 unique (name);

    alter table products 
       add constraint UK_8nj97xe4vc5jmbxk2skrr0fam unique (description);

    alter table products 
       add constraint UK_o61fmio5yukmmiqgnxf8pnavn unique (name);

    alter table products_order 
       add constraint UK_aantus71gj1wd5mf9qpq7k4sv unique (description);

    alter table products_order 
       add constraint UK_asdr6733v2gn6ehlppo7sxqxt unique (name);

    alter table users 
       add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table cart_details 
       add constraint FKkcochhsa891wv0s9wrtf36wgt 
       foreign key (cart_id) 
       references carts (id);

    alter table cart_details 
       add constraint FK9rlic3aynl3g75jvedkx84lhv 
       foreign key (product_id) 
       references products (id);

    alter table carts 
       add constraint FKb5o626f86h46m4s7ms6ginnop 
       foreign key (user_id) 
       references users (id);

    alter table categories 
       add constraint FKsaok720gsu4u2wrgbk10b5n8d 
       foreign key (parent_id) 
       references categories (id);

    alter table order_details 
       add constraint FKjyu2qbqt8gnvno9oe9j2s2ldk 
       foreign key (order_id) 
       references orders (id);

    alter table order_details 
       add constraint FKtaqyr6rmv2vwcl6nuhi0lacq 
       foreign key (product_order_id) 
       references products_order (id);

    alter table orders 
       add constraint FK32ql8ubntj5uh44ph9659tiih 
       foreign key (user_id) 
       references users (id);

    alter table products 
       add constraint FKog2rp4qthbtt2lfyhfo32lsw9 
       foreign key (category_id) 
       references categories (id);

    alter table products_order 
       add constraint FKqioumu0qf16j0lniysv3nnmos 
       foreign key (category_id) 
       references categories (id);
