-- 1. 2021 03 19금
-- emp 테이블에 있는 모든 데이터 검색하기
SELECT * FROM emp;
SELECT * FROM emp WHERE DEPTNO = 10; -- Selection(조건에 해당하는 row를 검색)
-- emp 테이블에서 사원번호, 이름, 업무, 급여를 검색
SELECT empno, ename, job, sal FROM emp; -- Projection(원하는 컬럼만 디스플레이)


-- emp테이블에서 업무가 판매원인 직원의 이름과 업무와 상사번호를 디스프레이
SELECT ename, job, mgr FROM emp WHERE job='SALESMAN';

-- emp번호가 7698번인 직원을 검색
SELECT ename, empno, job FROM emp WHERE empno=7698;
-- #######################################################

-- 1. emp테이블에서 부서번호를 디스플레이 하세요 :: 10, 20, 30 
-- DISTINCT (중복 안되게, SELECT 바로 다음에 사용)
-- 정렬 -> ORDER BY (오름차순), desc (내림차순)
SELECT deptno FROM emp;
SELECT distinct(deptno) from emp;
SELECT distinct(deptno) from emp order by deptno;
SELECT distinct(deptno) from emp order by deptno desc;
SELECT distinct(job) from emp;
SELECT distinct(job) from emp order by job;

-- 2. emp테이블에서 입사년도가 빠른사람 순으로 정렬
SELECT * from emp order by hiredate;
-- 3. emp테이블에서 보너스가 가장 큰 사원순으로 정렬
select * from emp order by comm desc;
select * from emp order by comm; -- MySQL에서는 null값이 가장 작은 값!!

-- 4. emp 테이블에서 입사년도가 가장 늦은 사람 top 2명만 디스플레이
-- limit은 디스플레이할 row의 갯수를 제한할 수 있다. limit n (상위 n개만 출력)
select empno, ename, hiredate from emp order by hiredate desc limit 2;

-- #######################################################

-- 5. comm이 null인 사원을 디스플레이
/*
null 값은 연산, 비교, 할당 자체가 불가능한 값이다.
왜냐면 숫자가 아닌 값이기 때문이다.
comm=null 구문이 성립되지 않는다.
그래서 is null, 반대는 is not null을 사용한다.
*/
select ename, job, comm from emp where comm=null; -- X
select ename, job, comm from emp where comm is null; -- O
select ename, job, comm from emp where comm is not null; -- O

-- 6. 사원들의 연봉을 출력, 이때 사원이름, 급여, 연봉, 부서번호를 함께 디스플레이
-- comm이 null이기 때문에 제대로 출력되지 않아서 ifnull() 을 사용한다.
/*
ifnull(comm, 0)
1) comm이 null이 아니면 그대로 comm리턴하고
2) comm이 null이면 0으로 치환해서 리턴한다.
*/
select ename, sal, sal*12+comm, deptno from emp; -- X
select ename, sal, sal*12+ ifnull(comm, 0), deptno from emp; -- O

/*
sal*12+ ifnull(comm, 0) -> 이럴때
-> 컬럼에 사칙연산이 적용
	1) 사칙연산 우선순위 (PEMDAS)
    2) 디스플레이 되는 컬럼명이 길어진다. -> 별칭(Alias)을 지정해 주어야 한다!!
-> Alias 지정하는 방법 
	1) as 사용 :: as AnnualSalary
    2) as 생략 :: AnnualSalary
    3) alias명은 반드시 공백을 허용하면 안된다. 
		-> 그래서 다운표를 사용 : 'Annual Salary' or "Annual Salary"
*/
select ename, sal, sal*12+ ifnull(comm, 0) as AnnualSalary, deptno from emp; -- 1)
select ename, sal, sal*12+ ifnull(comm, 0) AnnualSalary, deptno from emp; -- 2)
-- select ename, sal, sal*12+ ifnull(comm, 0) Annual Salary, deptno from emp; -- X
select ename, sal, sal*12+ ifnull(comm, 0) "Annual Salary", deptno from emp; -- 3)

-- AnnualSalary Alias로 정렬 가능한지 확인
-- 1)
select ename, sal, sal*12+ ifnull(comm, 0) AnnualSalary, deptno 
from emp 
order by sal*12+ ifnull(comm, 0);
-- 2) Alias로 정렬 가능하다
select ename, sal, sal*12+ ifnull(comm, 0) AnnualSalary, deptno 
from emp 
order by AnnualSalary;

-- #######################LIKE 연산자와 와일드 카드################################
-- 7. 직원 중에서 2번째 이름이 A로 시작하는 직원을 검색
select ename from emp where ename like '_A%';

-- 직원의 이름이 R로 끝나는 직원을 검색
select ename from emp where ename like '%R';

-- 직원들 중에서 81년도에 입사한 직원을 검색
select ename, hiredate from emp where hiredate like '%81%';
select ename, hiredate from emp where hiredate like '__81%';

-- #######################IN 연산자################################
-- 8. 직원의 상사번호가 7902이거나 7566이거나 7788인 사원을 검색
select empno, ename, mgr from emp where mgr=7902 or mgr=7566 or mgr=7788;
select empno, ename, mgr from emp where mgr in (7902,7566,7788); -- same as above

-- 9. 직원의 상사번호가 7902가 아니고 7566도 아니고 7788도 아닌 사원을 검색
select empno, ename, mgr from emp where mgr!=7902 and mgr!=7566 and mgr!=7788;
select empno, ename, mgr from emp where mgr not in (7902,7566,7788);

-- ============================================================================================
-- 2021. 03. 22. 월요일
/*
MySQL 함수
1. 문자관련 함수

2. 숫자관련 함수

3. 날짜관련 함수

4. 분석 함수

*/
-- 1. 문자관련 함수
-- concat('문자열1', '문자열2') :: 문자열( 혹은 컬럼)들을 연결하는 함수
select concat(ename, job) from emp;
select concat(ename, ' ', job) from emp;
select concat(ename, ' is a ', job) from emp;
select concat(ename, ' is a ', job) "emps information" from emp;
select concat('Good','Morning') "Morning Greet"; -- Oracle처럼 dual 테이블 없이 바로 사용가능하다.

-- insert('문자열','시작위치','길이','새로운 문자열') :: 문자열의 시작위치부터 길이만큼 새로운 문자열로 대치 :: SALESMANS --> SALESPERSON 변경
select job from emp;
select insert(job, 6, 6, 'PERSON') from emp where job='SALESMAN';

-- instr('문자열', '찾는문자열') ::
select instr(job, 'A') from emp where job = 'SALESMAN';

-- substr() :: 문자열 중에서 부분을 추출하는 기능 :: SALESMAN --> SALES만 추출
select ename, substr(job, 1, 5) job from emp where job = 'SALESMAN';

-- EMP 테이블에서 JOB이 MAN으로 끝나는 업무를 가진 직원들의 이름과 업무를 출력
-- 1) substr()
select ename, job from emp where substr(job, -3, 3) = 'MAN'; -- 뒤에서 3번째 글자 3개가 MAN
-- 2) instr() :: emp 테이블에서 job이 n으로 끝나는 업무를 가진 직원들의 이름과 업무를 출력
select ename, job from emp where instr(job, 'N') = 8;
-- 3) like 연산자
select ename, job from emp where job like '%MAN';

-- 2. substr() 사용해서 직원들의 입사한 년도를 출력하세요
select hiredate from emp;
select ename, substr(hiredate, 1, 4) from emp; -- year
select ename, substr(hiredate, 6, 2) from emp; -- month
select ename, substr(hiredate, 9, 2) from emp; -- day

-- 위의 내용을 그대로 날짜 함수를 이용해서 동일하게 출력
select ename as 이름, year(hiredate) '입사년도', month(hiredate) '입사월', day(hiredate) '입사일' from emp;

--  ################ 숫자함수
-- ABS(), CEILING(), ROUND(), FLOOR()--음수일때 제외, TRUNCATE(), MOD() -- %
-- 1. 사장인 사원과 SCOTT인 사람의 급여의 차이를 검색
select sal from emp where ename='KING';
select sal from emp where ename='SCOTT';
select distinct abs((select sal from emp where ename='SCOTT')-(select sal from emp where ename='KING')) 급여차이 from emp;

-- 2. 사원번호가 홀수인 사원의 이름과 사원번호를 검색 :: MOD()
select ename, empno from emp where mod(empno, 2) = 1;

-- job이 SALESMAN인 모든 사원에 대해서 보너스에 대한 급여비율의 나머지를 검색
select ename, job, sal, comm, mod(sal, comm) "급여비율의 나머지" from emp where job = 'SALESMAN';

-- ROUND(), TRUNCATE(), FLOOR()의 차이점과 사용법 정리
select round(45.923); -- 46, default는 정수... ,0이 생략됨
select round(45.923, 0);
select round(45.923, 2); -- 소수점 2번째 자리까지 표시..3번째에서 반올림이 진행
select round(45.925, 2); -- 45.93
select round(45.925, -1); -- .을 중심으로 일의 자리에서 반올림 진행.. 50으로 출력

select floor(45.923); -- 소수점을 버린다
-- select floor(45.923,2);
select floor(-45.923); -- 음수는 floor에 쓰지 않는다.. -46

select truncate(45.923); -- 45
select truncate(45.923,0);
select truncate(45.925,2); -- 45.92
-- select truncate(-45.923); ERROR!!

select greatest(1,2,3); -- 3
select least(1,2,3);

select ceiling(45.923);

--  ################ 날짜함수
-- year(), month(), day()
-- now(), sysdate() --> 날짜와 함께 시각도 동시에 출력
select now();
select sysdate();

-- curdate() --> 현재 날짜만 출력
select curdate() today;
select current_date();

-- 시각만 출력
select curtime();
select current_time();

/*
날짜 - 날짜 = 일수
날짜 + 숫자 = 날짜
날짜 - 숫자 = 날짜
*/
-- 1. 영심이가 남자친구를 사귄지 오늘로부터 100일째 되는 날을 구하기 :: 날짜(curdate()) + 숫자(100)
-- select curdate()+100; Oracle에서 돌아감
select date_add(curdate(), interval 100 day);

-- 2. 강지원이가 지금까지 살아온 생애...(오늘 - 생일 - 기간)
-- datediff() 사용
-- select (curdate()-'1998-10-14') 살아온여생;
select datediff(curdate(), '1998-10-14'); -- 암시적 형변환
select datediff(curdate(), str_to_date('1998-10-14', '%Y-%m-%d')); -- 명시적 형변환

-- 3.  MANAGER 업무에 한해서 입사한 날로부터 오늘까지의 근무한 주수를 구하고 Alias는 근무주수로 
select ename, job from emp;
select ename, job, hiredate, round(datediff(curdate(), hiredate)/7) "근무주수" from emp where job = 'MANAGER';

-- 4. 상사가 없는 사원의 mgr 갈럼값을 '없음'으로 치한해서 검색
select ename, mgr from emp;
select ename, ifnull(mgr, '없음') CEO from emp where ename='KING';
select ename, ifnull(convert(mgr,char), '없음') CEO from emp where ename='KING';
-- convert(컬럼명, 변환형)

-- ###################### 그룹 함수 :: COUNT, MAX, MIN, AVG, SUM #####################################
-- 숫자 데이터에만 적용 :: SUM(), AVG()
-- 모든 데이터에 적용 :: MAX(), MIN(), COUNT()
-- 그룹 함수 연산시 NULL값은 제외하고 연산이 진행된다.

-- count() :: 테이블 행(row)의 수를 리턴
select count(empno) from emp; -- empno 칼럼에 해당하는 행의 수를 리턴
select count(*) from emp; -- 전체행의 수를 리턴...* 모든 컬럼
select count(-1) from emp; -- 맨 마지막 행의 number를 리턴한다
select count(mgr) from emp; -- mgr 컬럼에는 null값이 1개 있다...13
select count(comm) from emp;
select count(job) from emp;
select count(distinct(job)) from emp;

-- 1. 입사한지 가장 오래된 사원의 이름과 입사일, 가장 최근에 입사한 사원의 이름과 입사일을 검색
select min(hiredate), max(hiredate) from emp;

-- 2. 모든 사원의 급여의 총합
select sum(sal) "급여의 총합" from emp; 

-- 3. 부서번호가 10번 이거나 20번인 사원의 인원수는? ... count()
select count(deptno) from emp where deptno in(10,20);
select count(deptno) from emp where deptno=10 or deptno=20;

-- 4. 모든 사원들의 평균급여
select round(avg(sal),2) from emp;

-- 5. 모든 사원들의 보너스의 평균을 검색 -- 그룹함수와 NULL값이 연결될때 주의한다.
select round(avg(comm)) from emp; -- 문제있다..
select round(avg(ifnull(comm,0))) from emp; -- null도 포함해야지 모든 사뭔들의 보너스 평균을 구할 수 있다.

-- ---------------------------------------------------------------------------------------------
-- 그룹함수에 적용되지 않는 컬럼이 select절에 나열되면 안된다.
-- 그룹함수에 적용되지 않는 컬럼은 반드시 GROUP BY절 뒤에 명시되어져야 한다.
select deptno, avg(sal) from emp; -- 1)
select deptno, round(avg(sal)) from emp group by deptno order by deptno; -- 2) 그룹을 세분화 한다.
select deptno DName, round(avg(sal)) from emp group by DName order by DName; -- 3)group by 뒤에 alias가 가능하다.alter

--  위와 동일한 쿼리 + 단 20번 부서는 제외 
select deptno, round(avg(sal)) from emp where deptno!=20 group by deptno order by deptno; -- 순서 기억!!!

-- 1. 입사년도별 사원의 인원수를 출력 Alias로...count()
select year(hiredate) 입사년도, count(*) 인원수 from emp group by year(hiredate) order by year(hiredate); -- 1)
select year(hiredate) 입사년도, count(*) 인원수 from emp group by 입사년도 order by 입사년도; -- 2)

select date_format(hiredate, '%Y') 입사년도, count(*) 인원수 from emp group by 입사년도 order by 입사년도; -- 3) date_format!!!

-- 2021. 03. 23. 화요일
-- 부서별 평균급여가 2000 달러 이상인 부서번호와 평균급여를 디스플레이
select deptno, avg(sal) from emp where avg(sal) >= 2000 group by deptno; -- ERROR
select deptno, avg(sal) from emp having avg(sal) >= 2000 group by deptno; -- ERROR
select deptno, avg(sal) from emp group by deptno having avg(sal) >= 2000; -- having절은 group by절 뒤에 와야 한다.
select deptno, avg(sal) from emp where deptno!=10 group by deptno having avg(sal) >= 2000;
/*
그룹함수는 WHERE절에서 사용 할수 없다!!
실행순서와 연관이 있다.
*/

-- 1. 최대 급여가 2900달러가 넘는 부서들의 최대급여를 출력
select deptno, max(sal) from emp group by deptno having max(sal) > 2900;
