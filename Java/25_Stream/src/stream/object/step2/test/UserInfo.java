package stream.object.step2.test;

import java.io.Serializable;

public class UserInfo implements Serializable {
	public static final String DEFAULT_NAME = "홍길동";
	public static final int DEFAULT_AGE = 19;
	private String name;
	private int age;
	transient String password;
	/*
	 * password 같은 값은 고객의 정보중에서 노출시키면 위험한 정보에 해당
	 * 이런 정보는 실질적인 값을 통과시키지 않고 기본값으로 통과시킨다.
	 * transient 키워드를 필드 앞에 지정한다.
	 */
	public UserInfo(String name, int age, String password) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
	}
	public UserInfo() {
		this(DEFAULT_NAME, DEFAULT_AGE, "1234");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + ", password=" + password + "]";
	}
	
}
