/*
 * Outside of basic CRUD, you can get a lot more utility out of SQL. For one, when using a
 * relational database management system (RDBMS) like Postgres, you create relationships
 * between entities. This can be helpful, but it comes at a cost sometimes: You might have
 * to perform multiple queries just to get a single complete record.
 */

-- It is tedious to have to write 2 queries just to get a more full picture. Not only that,
--but I can't even view the full record together like this.
select * from cupcake where cupcake_flavor = 'Lava Cake';
select * from bakery where bakery_id = 1;

/*
 * The solution to this problem is called a "join". A join allows you to combine two tables
 * so that you can see a more "complete" record.
 */

-- Our first join is our full or outer join. Your full join will give you all of the records
-- from both tables even if it can't make a record on table 1 up with a record on table 2.
select * from cupcake full outer join bakery on cupcake.cupcake_bakery_id = bakery.bakery_id;

-- If you want a more narrow result set, you can use an inner join. Note that inner joins will
-- NOT substitute null values when a record from table 1 can't be matched up with a record
-- from table 2. Those records just won't be included.
select * from cupcake inner join bakery on cupcake.cupcake_bakery_id = bakery.bakery_id;

-- You can also use your left or right joins.

-- A left join guarantees a representation of all records on the left table (cupcake in this
-- case).
select * from cupcake left join bakery on cupcake.cupcake_bakery_id = bakery.bakery_id;

-- A right join guarantees a representation of all records on the right table (bakery in this
-- case).
-- NOTE: You can use aliases for your table names so that you can shorten your queries for
-- readability.
select * from cupcake c right join bakery b on c.cupcake_bakery_id = b.bakery_id;

-- And you have your cross joins as well:

-- A cross join returns a number of records that is the product of the number of records on table 1
-- and the number of records on table 2.
select * from cupcake cross join bakery;

-- This is technically still a join, but we call it a "natural join" because we don't use the
-- join keyword to achieve it.
select c.cupcake_flavor, cupcake_cost, b.bakery_name, b.bakery_state from cupcake c, bakery b 
where c.cupcake_bakery_id = b.bakery_id;
