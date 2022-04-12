/*
 * There are several sublanguages of SQL which help us complete different tasks. The first 
 * sublanguage we'll focus on is called Data Definition Language (DDL).
 * 
 * DDL pertains to the creation of the structures/objects that will organize our data.
 * The most common object is a table.
 */

drop table cupcake;
-- The "if not exists" clause is optional.
create table if not exists cupcake(
	cupcake_flavor varchar unique not null,
	cupcake_cost numeric not null,
	--We should just reference our existing bakery information rather than respecifying it.
	-- This is a foreign key constraint.
	cupcake_bakery_id integer references bakery(bakery_id),
	cupcake_calories numeric not null check (cupcake_calories >= 0),
	cupcake_is_gluten_free boolean not null,
	cupcake_is_vegan boolean not null
);

drop table bakery;
create table if not exists bakery(
-- Note that a primary key constraint specifies that a column is unique and not null.
	bakery_id integer primary key,
	bakery_name varchar unique not null,
	bakery_street varchar not null,
	bakery_state varchar not null,
	bakery_zip_code varchar not null,
	bakery_specialty varchar
);

drop table cupcake_bakery;
-- In order to model a "many to many" relationship, we actually need a join table (also called a bridge table).
create table cupcake_bakery(
	cupcake_flavor varchar references cupcake(cupcake_flavor),
	bakery_id integer references bakery(bakery_id),
	-- You can add constraints at the end of a table rather than inline. We will add a primary
	-- key constraint to this table below. It will be a composite primary key.
	primary key(cupcake_flavor, bakery_id)
);

-- You can also alter tables because sometimes we can't just drop a table and recreate it
-- with no consequences as we could lose data.
alter table cupcake alter column cupcake_bakery set data type text;

/*
 * Our second sublanguage of SQL is called Data Manipulation Language (DML). This sublanguage
 * pertains to writing data to your tables, reading data, deleting data, or updating data.
 * 
 * We tend to refer to these basic manipulations as simply "CRUD".
 * 
 * Create
 * Read
 * Update
 * Delete
 * 
 * NOTE: Technically speaking, you've already seen the 3rd sublanguage of SQL. It's called
 * Data Query Language (DQL). Data Query Language pertains to querying the database (just
 * reading). In essence, using the "select" statement for a simple query.
 */

-- Reading from a table:
-- The "*" represents all columns on the table. You can be more specific about the retrieved
-- columns however.
select * from cupcake;
select * from bakery;
select cupcake_cost, cupcake_flavor, cupcake_bakery from cupcake;
select * from cupcake where cupcake_calories <= 300;

-- Creating records.
/*
 * Note that we have done a multi insert, but of course you don't have to insert multiple
 * cupcakes at once.
 */
insert into cupcake values('German Chocolate', 2.50, 2, 500, false, false),
('Strawberry', 4, 2, 400, true, true);
insert into cupcake values('Lava Cake', 1, 1, 1000, false, false);
insert into cupcake values('Carrot Cake', 6, 1, 0, true, false);
insert into cupcake values('Upsidedown Cake', 6, null, 0, true, false);
insert into bakery values(1, 'Sugar Bee Sweets', 'West Street', 'TX', '87643', 'Wedding Cakes');
insert into bakery values(2, 'CC Bakery', 'Christina Street', 'IL', '77777', null);
insert into cupcake_bakery values('Strawberry', 1);
insert into cupcake_bakery values('Lava Cake', 1);
insert into cupcake_bakery values('Lava Cake', 2);


-- Updating a record. ALWAYS use a where clause.
update cupcake set cupcake_calories = 350 where cupcake_flavor = 'Carrot Cake';

-- Deleting a record. Again, ALWAYS use a where clause.
delete from cupcake where cupcake_flavor = 'Strawberry';

/*
 * Our 4th sublanguage of SQL is called Transaction Control Language (TCL). TCL pertains to
 * finalizing or reverting changes to our schema.
 * 
 * A transaction describes a unit of work that you are doing on your database. Think of it as
 * a collection of all the inserts, updates, etc. that you have performed together.
 * 
 * A transaction has 4 properties: ACID
 * Atomicity - all or nothing; either all changes are finalized or all changes are reverted.
 * Consistency - applies when dealing with concurrent transactions; concurrent transactions
 * should abide by the same constraints.
 * Isolation - applies to concurrent transactions; one transaction should not affect another
 * concurrent transaction. There are 4 levels of isolation: read uncommitted (bad practice),
 * read committed (this is typically the default for database management systems),
 * repeatable reads (prevents nonrepeatable reads), serializable (prevents phantom reads)
 * Durability - if a transaction has been committed, this should guarantee that even in the
 * case of database failure, your records should still be persisted.
 */

-- If we're being proper, we should always be committing our changes to our DB.
commit;

-- Note, also, that it's possible to revert changes. Also note that you should be deliberate
-- about where transactions begin and where they end.
begin transaction;
insert into cupcake values('Cherry Cake', 6, 'Sugar Bee Sweets', 0, true, false);
savepoint before_deleting_cupcakes;
delete from cupcake where cupcake_bakery = 'CC Bakery';
rollback to before_deleting_cupcakes;

/* Our final sublanguage of sql is called data control language (DCL). DCL pertains to
 * restricting access to your DB.
 */

create user jim with password 'password';