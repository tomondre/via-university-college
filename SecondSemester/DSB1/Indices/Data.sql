select count(*) from pgbench_branches;

select count(*) from pgbench_tellers;

select count(*) from pgbench_accounts;

select max(bbalance) from pgbench_branches;

select max(tbalance) from pgbench_tellers;

select max(abalance) from pgbench_accounts;

select count(*) from pgbench_accounts where filler = '4321';

select max(bbalance) from pgbench_branches, pgbench_accounts
where pgbench_accounts.bid = pgbench_accounts.bid and abalance > '29999000';

select max(bbalance) from pgbench_branches, pgbench_tellers
where tbalance = bbalance and tbalance > '29999000';

select max(tbalance) from pgbench_branches, pgbench_tellers
where tbalance = bbalance and pgbench_branches.filler = '4321';

select abalance from pgbench_accounts where aid = '2999324';

select count(*) from pgbench_accounts where abalance between '25000000' and '30000000';

create index abalance on pgbench_accounts(abalance);



