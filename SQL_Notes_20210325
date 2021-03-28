-- ################# JOIN #################################
-- 2021. 03. 25. 목요일

/*
2개이상(혹은 하나도 가능)의 테이블로부터 테이터를 가져오는 방법에 JOIN기법이 사용된다.
select * from emp; emp 테이블에 있는 사원의 정보를 받아온다.
select * from dept; dept 테이블에 있는 부서의 정보를 받아온다.
이때 사원 정보와 부서정보를 둘다 받아오려면? --> 조인을 사용해야 한다.
*/
select * from emp, dept; -- Cartesian Product 단순한 재료의 집합
-- Cartesian Product 이란?
/*
emp, dept테이블의 수평적인 결합
14  X  4  = 56

어떨때 만들어질까?
1) 조인 조건을 잘못주었거나
2) 조인 조건을 생략했거나
*/
-- ##### 조인 (Equi Join, = 연산자를 사용하는 조인, 2테이블의 공통적으로 연결된 컬럼을 = 표시)
-- 1)
select * from emp, dept where emp.deptno = dept.deptno;
-- 하나 이상의 테이블로부터 테이터를 질의하기 위해서 조인을 사용함
-- where 절에 조인조건을 = 를 이용해서 작성
-- 하나 이상의 테이블에 똑같은 컬럼 이름이 있을때 이런 컬럼이 바로 조인 조건이 되며 이 컬럼명 앞에 테이블을 지정한다

-- 문제점 --> * 사용하지 말자. 노출되면 안되는 정보들이 다 노출된다.

-- 2) step2
select empno, ename, sal, deptno, dname, loc from emp e, dept d where e.deptno = d.deptno; -- error!!!..굉장한 성능장애를 가져온다.

-- 조인에서는 컬럼명 앞에 테이블을 지정
-- 컬럼명 앞에 테이블 alias를 지정하자
select e.empno, e.ename, e.deptno, d.dname, d.loc from emp e, dept d where e.deptno = d.deptno;

-- 3) step3 조인 조건과 함께 비조인 조건을 동시에 사용
-- 사원이름, 급여, 부서번호, 부서이름, 부서위치를 검색... 단 급여가 2000이상이고 30번 부서에 한해서만
select e.ename, e.sal, d.deptno, d.dname, d.loc 
from emp e, dept d 
where e.deptno = d.deptno
and e.sal > 2000
and d.deptno = 30;

-- 1. 뉴욕에서 근무하는 사원의 이름과 급여를 검색
select e.ename, e.sal, d.loc from emp e, dept d
where e.deptno = d.deptno
and d.loc = 'NEW YORK'; 

-- ############# SELF JOIN ####################
-- 2. SMITH의 상사의 이름을 검색
-- 1) smith의 mgr 컬럼을 검색
-- 2) mgr 컬럼값이 empno인 사람의 이름을 찾는다
select empno, ename, mgr from emp;
select empno, ename from emp;
-- ->
select e.empno 사원번호, e.ename 사원이름, m.ename 상사이름 
from (select empno, ename, mgr from emp) e, (select empno, ename from emp) m
where e.mgr=m.empno
and e.ename = 'SMITH';

select e.ename 사원이름, m.ename 상사이름 
from emp e, emp m
where e.mgr=m.empno
and e.ename = 'BLAKE';
