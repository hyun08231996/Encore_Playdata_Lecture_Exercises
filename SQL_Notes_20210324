-- ################# Sub Query #################################
-- 2021. 03. 24. 수요일
/*
1) WHERE 절에서 사용되는 서브쿼리
2) HAVING 절에서 사용되는 서브쿼리
3) FROM 절에서 사용되는 서브쿼리
*/

-- 1. CLARK의 급여보다 더 많은 급여를 받는 사원은?
-- 1) 서브쿼리
select sal from emp where ename='CLARK'; -- 2450
-- 2) 메인쿼리
select ename, sal from emp where sal > 2450;
-- 3) sub+main query
select ename, sal from emp where sal > (select sal from emp where ename='CLARK');

-- 2. ename이 KING인 사원과 같은 부서에서 근무하는 사원을 검색 -- ?에 해당하는 질의
select ename, deptno from emp where deptno = (select deptno from emp where ename='KING');

-- 3. 10번 부서에서 일하는 사원중 사원의 전체 평균급여보다 더 많은 급여를 받는 사원 검색
select ename, sal from emp where sal > (select avg(sal) from emp) and deptno=10;

-- 4. job별 가장 적은 평균급여를 검색
select min(avg(sal)) from emp group by job; -- 오라클에서 가능, mysql에서 불가능... 그룹함수 중첩 안됨

select job, round(avg(sal)) from emp group by job
having avg(sal) = (select min(asal) from 
(select avg(sal) asal from emp group by job) s); -- 테이블이 리턴되는 서브쿼리는 반드시 alias를 지정한다.

select job, avg(sal) asal from emp group by job order by asal limit 1;

-- scott의 급여보다 더 많은 급여를 받는 사원을 검색 (테이블 알리야스 사용)
select * from emp where sal>(select sal from emp where ename='SCOTT');
select * from emp a, (select sal from emp where ename='SCOTT') b
where a.sal>b.sal;

-- ################## 단일행 연산자 사용하는 서브쿼리
/*
 =, >, <, !=, <=, >=
 */
 -- 1. 직속상관(mgr)이 KING인 사원의 이름과 급여를 검색
 select ename, mgr, sal from emp where mgr = (select empno from emp where ename='KING');
 
 -- 2. job이 사원 7369의 업무와 같고, 급여가 사원 7876보다 많은 사원을 검색
select ename, job, sal from emp where 
job = (select job from emp where empno=7369) 
and sal > (select sal from emp where empno=7876);

-- 3. 부서별 최소급여 중에서 20번 부서의 최소급여보다 더 큰 최소급여를 검색
select deptno, min(sal) from emp
group by deptno
having min(sal) >
(select min(sal) from emp where deptno=20);

-- 서브쿼리 결과가 다중행으로 나올때는 단일행 연산자 사용못함
select empno, ename from emp
where sal=(select min(sal) from emp group by deptno); -- subquery가 3row를 리턴하기 때문에 = 을 사용할 수 없다. 다중 연산자를 사용해야한다.

select empno, ename, sal, deptno from emp
where sal in (select min(sal) from emp group by deptno); 

/*
다중행 연산자 :: IN, ANY, ALL
ANY - 메인쿼리의 비교조건이 서브쿼리 결과와 하나이상만 일치하면 참이됨
ALL - 메인쿼리의 비교조건이 서브쿼리 결과와 모든 값이 일치하면 참이됨
IN - 여러개 중에서 같은 값을 찾음

> ANY - 최소값보다 많음
< ANY - 최대값보다 작음

> ALL - 최대값보다 많음
< ALL - 최소값보다 작음
*/

-- 1. 급여를 3000 이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원을 검색
select ename, sal, deptno from emp where deptno in(select distinct deptno from emp where sal >=3000);

-- <ANY
-- 2. 급여가 어떤 점원(clerk)보다도 작으면서 CLERK이 아닌 사원을 검색
-- 1) select sal from emp where job='CLERK'; (800, 1100,950,1300) 이중 하나만 일치해도 된다 <ANY
-- 2)
select empno, ename, sal, job from emp
where sal < any(select sal from emp where job='CLERK')
and job != 'CLERK';

-- 3. 급여가 모든 부서의 평균급여보다 많은 사원을 검색 (모든 평균값 보다 높아야한다) >ALL
-- 1)
select avg(sal) from emp group by deptno;
select empno, ename, job, sal from emp
where sal > all(select avg(sal) from emp group by deptno);
