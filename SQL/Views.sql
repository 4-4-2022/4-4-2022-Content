/* A view provides a simpler way of querying a table (or joined tables). A view creates
  a temporary or virtual "table". Note that the DBMS actually does run the underlying
  query every single time you select from the view.
  
  Also note that you CAN modify the underlying records by running an update or insert a 
  view - but only under certain circumstances. The view we've created below is not an
  updatable view because it joins two tables.
  */

select * from cupcake full join bakery on cupcake.cupcake_bakery_id = bakery.bakery_id;

drop view cupcake_bakery_view;
create or replace view cupcake_bakery_view as 
select * from cupcake full join bakery on cupcake.cupcake_bakery_id = bakery.bakery_id;

-- Not updatable!
select * from cupcake_bakery_view;

/*
 * Indexing allows your DBMS to more easily find records on a table. This is because indexing
 * writes records to disk by ordering the records by their index. Primary key columns are
 * automatically indexed. That said, you can actually index your own columns.
 * 
 * Indexing a column is about improving performance when using that column to search for
 * records on that particular table.
 */

drop index bakery_bakery_name_idx;
create unique index on bakery(bakery_name);

/*
 * Set operations combine the results of queries. This means that you have at least two
 * different queries when working with set operations.
 */

-- This is a join, and it's ONE query.
select * from cupcake full join bakery on cupcake.cupcake_bakery_id = bakery.bakery_id;

/*
 * In order to use a set operation, the number of columns in each result set must be the same.
 * If result set A has 3 columns, result set B must have 3 columns. It is also the case that
 * the columns will be stacked on top of each other must have the same data type.
 */

select * from cupcake;

/*
 * This set operation (union all) returns all of the results from the first result and all
 * of the results from the second result even if there are duplcates.
 */
select cupcake_flavor from cupcake union all select bakery_name from bakery;

-- Note that union (without the "all" added) will not include duplicates.

select * from cupcake union select * from cupcake;

/*
 * We can also use the "intersect" operation. What is in result set A that is also in result
 * set B?
 */

select * from cupcake intersect select * from cupcake;
select cupcake_flavor from cupcake intersect select bakery_name from bakery;

/*
 * There's also the "except" operation. This is "minus" in some other dialects.
 * The point of except is to find records that are in result set A that are NOT in reulst set
 * B. In other words, you're looking for records that are unique to result set A.
 */

select * from cupcake except select * from cupcake;
