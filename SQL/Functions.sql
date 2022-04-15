/* 
 * SQL has several built-in functions that make data transformation and aggregation easier.
 * 
 * You generally divide these functions into 2 categories: scalar function or aggregate
 * functions.
 * 
 * Scalar functions are the easiest to use and understand. They take a single value and
 * return a single value. Examples of scalar functions include: upper, lower, concat,
 * sin, cos, tan
 */

select bakery_id, upper(bakery_name), concat(bakery_street, ' ', bakery_state) from bakery;

/*
 * You also have your aggregate functions. These take multiple values and spit out a single 
 * value. Examples of aggegate avg, sum, count.
 */

select * from cupcake;
select avg(cupcake_cost) from cupcake;
select count(cupcake_flavor) from cupcake where cupcake_calories > 0;

/*
 * You're not limited to only getting a single result with aggregate functions because you
 * can use the "group by" keyword to group the results of your query.
 */

select avg(cupcake_cost), cupcake_bakery_id from cupcake group by cupcake_bakery_id;
select avg(cupcake_cost), cupcake.cupcake_is_vegan from cupcake group by cupcake.cupcake_is_vegan;
select avg(cupcake_cost), cupcake.cupcake_is_gluten_free from cupcake group by cupcake.cupcake_is_gluten_free;

/*
 * You can also make your own functions in SQL. You can do so using pl/pgSQL. This stands
 * for procedural language/Postgres Sequential Query Language. This is just a programming
 * language inside of SQL that allows you to create custom functions.
 */
drop function update_cupcake;
create or replace function update_cupcake() returns trigger
language plpgsql
as $$
-- Function logic goes in between the dollar quotes.
	begin 
		update cupcake set cupcake_bakery_id = null where cupcake_bakery_id = old.bakery_id;
		return old;
	end;
$$;

/*
 * This function is designed to be paired with a trigger. A trigger automatically fires
 * when a specific event on a table occurs. You get to decide what that event is and what
 * the table is.
 */

drop trigger on_delete_modify;
create trigger on_delete_modify
before delete on bakery
-- This trigger is fired off for every single row that is affected by the event.
for each row
execute procedure update_cupcake();

select * from cupcake;
select * from bakery;

delete from bakery where bakery_id = 4;
